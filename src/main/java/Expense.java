import java.util.ArrayList;

public class Expense {
    public Integer id;
    public Integer group_id;
    public Integer friendship_id;
    public Integer expense_bundle_id;
    public String description;
    public boolean repeats;
    public String repeat_interval;
    public boolean email_reminder;
    public Integer email_reminder_in_advance;
    public String next_repeat;
    public String details;
    public Integer comments_count;
    public boolean payment;
    public String creation_method;
    public String transaction_method;
    public boolean transaction_confirmed;
    public Integer transaction_id;
    public String cost;
    public String currency_code;
    public ArrayList<Repayment> repayments;
    public String date;
    public String created_at;
    public UserWithCustom created_by;
    public String updated_at;
    public UserWithCustom updated_by;
    public String deleted_at;
    public String deleted_by;
    public Category category;
    public Receipt receipt;
    public ArrayList<UserExpanded> users;

    public class Repayment {
        public Integer from;
        public Integer to;
        public String amount;
    }

    public class UserWithCustom {
        public Integer id;
        public String first_name;
        public String last_name;
        public Picture picture;
        public String custom_picture;
    }

    public class Picture {
        public String medium;
    }

    public class Category {
        public Integer id;
        public String name;
    }

    public class Receipt {
        public String large;
        public String original;
    }

    public class UserExpanded {
        public User user;
        public Integer user_id;
        public String paid_share;
        public String owed_share;
        public String net_balance;
    }

    public class User {
        public Integer id;
        public String first_name;
        public String last_name;
        public Picture picture;
    }
}