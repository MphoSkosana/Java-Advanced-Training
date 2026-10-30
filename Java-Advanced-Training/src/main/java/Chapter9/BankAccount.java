package Chapter9;

enum AccountType{
    DEBIT,
    SAVINGS,
    CREDIT,
    CHEQUE,
    LOAN
}

public class BankAccount {
    private String accountHolder;
    private String accountNumber;
    private AccountType accountType;
    private double balance;

    public BankAccount(String accountHolder, String accountNumber, AccountType accountType, double balance) {
        setAccountHolder(accountHolder);
        setAccountType(accountType);
        setAccountNumber(accountNumber);
        setBalance(balance);
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {

       String accPrefix;

       if (getAccountType() == AccountType.DEBIT){
           accPrefix = "DB-";
       }else if (getAccountType() == AccountType.LOAN){
           accPrefix = "LN-";
       }else if (getAccountType() == AccountType.CREDIT){
           accPrefix = "CR-";
       }else if (getAccountType() == AccountType.SAVINGS){
           accPrefix = "SV-";
       }else {
           accPrefix = "CQ-";
       }

       this.accountNumber = accPrefix + accountNumber;

    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount){
        if (amount <= 0){
            throw new IllegalArgumentException("Cannot deposit negative (-) or zero (R0) amount.[" +
                   amount+ "]" );
        }

        this.balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0){
            throw new IllegalArgumentException("Cannot withdraw negative (-) or zero (R0) amount.[" +amount+ "]" );
        }
        if (amount > getBalance()){
            throw new InsufficientFundsException("Insufficient Funds...\nCurrent Balance: " +getBalance()+
                    "\nRequested Amount: " +amount);
        }

        this.balance -= amount;
    }

    public String displayDetails(){
        return String.format("""
                Account Holder   :   %s
                Account Number   :   %s
                Account Type     :   %s
                Balance          :   %.2f""",
                getAccountHolder(), getAccountNumber(), getAccountType(), getBalance());
    }
}
