package Chapter9;

public class BankAccountRunner {
    static void main() throws InsufficientFundsException {
        try {
            BankAccount objAcc = new BankAccount("Jessica Jones", "98745612", AccountType.CHEQUE, 21000);

            objAcc.deposit(600);
            objAcc.withdraw(2200);

            System.out.println(objAcc.displayDetails());
        } catch (InsufficientFundsException | IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
