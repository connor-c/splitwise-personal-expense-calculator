import com.google.gson.Gson;
import java.io.FileWriter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Splitwise splitwise = new Splitwise("<Consumer Key>", "<Consumer Secret>");
        try
        {
            String expensesFileName = "expenses.csv";

            if (args.length == 1) {
                if ((args[0].length() < 4) || (!".csv".equals(args[0].substring(args[0].length() - 4)))) {
                  expensesFileName = args[0] + ".csv";
                } else {
                    expensesFileName = args[0];
                }
            }

            splitwise.util.setAccessToken("<Token>", "<Token Secret>", "<Raw Response>");

            UserFullyExpanded currentUser = new Gson().fromJson(splitwise.getCurrentUser(), UserFullyExpanded.class);
            int currentUserId = currentUser.user.id.intValue();
            String expensesJson = splitwise.getExpenses();
            Expenses expenses = new Gson().fromJson(expensesJson, Expenses.class);
            ArrayList<SimplifiedExpense> simplifiedExpenses = new ArrayList<SimplifiedExpense>();

            for (Expense expense : expenses.expenses) {
                if ((!expense.payment) && (!"debt_consolidation".equals(expense.creation_method))) {
                    simplifiedExpenses.add(simplifyExpense(currentUserId, expense));
                }
            }

            for (SimplifiedExpense simplifiedExpense : simplifiedExpenses) {
                if (simplifiedExpense.owedShared > 0) {
                    System.out.print(simplifiedExpense.description);
                    System.out.print("  ");
                    System.out.print(simplifiedExpense.date);
                    System.out.print("  ");
                    System.out.print(simplifiedExpense.creator);
                    System.out.print("  ");
                    System.out.print(simplifiedExpense.owedShared);
                    System.out.println();
                }
            }

            FileWriter csvWriter = new FileWriter(expensesFileName);
            csvWriter.append("Description");
            csvWriter.append(",");
            csvWriter.append("Date");
            csvWriter.append(",");
            csvWriter.append("Creator");
            csvWriter.append(",");
            csvWriter.append("Owed Share");
            csvWriter.append("\n");

            for (SimplifiedExpense simplifiedExpense : simplifiedExpenses) {
                if (simplifiedExpense.owedShared > 0) {
                    csvWriter.append(simplifiedExpense.description);
                    csvWriter.append(",");
                    csvWriter.append(simplifiedExpense.date);
                    csvWriter.append(",");
                    csvWriter.append(simplifiedExpense.creator);
                    csvWriter.append(",");
                    csvWriter.append(String.valueOf(simplifiedExpense.owedShared));
                    csvWriter.append("\n");
                }
            }

            csvWriter.flush();
            csvWriter.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static SimplifiedExpense simplifyExpense(int userId, Expense expense) {
        SimplifiedExpense simplifiedExpense = new SimplifiedExpense();

        simplifiedExpense.description = expense.description;
        simplifiedExpense.date = expense.date.substring(0, 10);
        simplifiedExpense.creator = expense.created_by.first_name + " " + expense.created_by.last_name;

        for (int i = 0; i < expense.users.size(); i++) {
            if (userId == expense.users.get(i).user_id) {
                simplifiedExpense.owedShared = Double.parseDouble(expense.users.get(i).owed_share);
                break;
            }
        }

        return simplifiedExpense;
    }

}


