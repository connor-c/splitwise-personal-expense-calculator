# Splitwise Personal Expense Calculator
Fills a .csv file and prints onto console the amounts you owe for recent Splitwise transactions. Uses sritejakv's 
[splitwise-java](https://github.com/sritejakv/splitwise-java) library (which uses the Splitwise API).

## Prerequisites
- Maven
- Java 11

## Usage
Execution of commands is to be done in the same directory as the pom.xml file.

### Build
1. Add your Splitwise API consumer key and consumer secret to line 7 of _src/main/java/Main.java_.
2. Add your token, token secret, and raw response to line 20 of _src/main/java/Main.java_(These values can be retrieved easily using the [token-tokensecret-rawresponse-retriever](https://github.com/connor-c/token-tokensecret-rawresponse-retriever).
3. `mvn clean`
4. `mvn compile`
5. `mvn package`

### Run
#### Run and save to a specifically named .csv file
`java -jar target/SplitwisePersonalExpenseCalculator-1.0-SNAPSHOT.jar SPECIFICNAME.csv` 
#### Run and save to expenses.csv
`java -jar target/SplitwisePersonalExpenseCalculator-1.0-SNAPSHOT.jar`