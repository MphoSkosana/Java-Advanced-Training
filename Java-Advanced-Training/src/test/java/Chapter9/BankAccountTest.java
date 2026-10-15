package Chapter9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    private static final double DELTA = 0.001;

    BankAccount objAcc;

    @BeforeEach
    void accountSetup() {
        objAcc = new BankAccount("Jessica Jones", "98745612", AccountType.CHEQUE, 21000);
    }


    @Test
    void testConstructorSetsAllFields() {
        assertEquals("Jessica Jones", objAcc.getAccountHolder());
        assertEquals("CQ-98745612", objAcc.getAccountNumber());
        assertEquals(AccountType.CHEQUE, objAcc.getAccountType());
        assertEquals(21000, objAcc.getBalance(), DELTA);
    }


    @ParameterizedTest
    @CsvSource({
            "DEBIT,   DB-",
            "LOAN,    LN-",
            "CREDIT,  CR-",
            "SAVINGS, SV-",
            "CHEQUE,  CQ-"
    })
    void testAccountNumberPrefixPerAccountType(AccountType type, String prefix) {
        BankAccount acc = new BankAccount("Test User", "123", type, 0);

        assertEquals(prefix + "123", acc.getAccountNumber());
    }


    @Test
    void testSetAccountHolder() {
        objAcc.setAccountHolder("Vanessa Villa");

        assertEquals("Vanessa Villa", objAcc.getAccountHolder());
    }

    @Test
    void testSetAccountType() {
        objAcc.setAccountType(AccountType.SAVINGS);

        assertEquals(AccountType.SAVINGS, objAcc.getAccountType());
    }

    @Test
    void testSetBalance() {
        objAcc.setBalance(5000.50);

        assertEquals(5000.50, objAcc.getBalance(), DELTA);
    }

    @Test
    void testSetAccountNumberAfterTypeChange() {
        objAcc.setAccountType(AccountType.LOAN);
        objAcc.setAccountNumber("555");

        assertEquals("LN-555", objAcc.getAccountNumber());
    }


    @Test
    void testDeposit() {
        objAcc.deposit(600);

        assertEquals(21600, objAcc.getBalance(), DELTA);
    }

    @Test
    void testInvalidDepositNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> objAcc.deposit(-200));
        assertEquals(21000, objAcc.getBalance(), DELTA);   // unchanged
    }

    @Test
    void testInvalidDepositZeroAmount() {
        assertThrows(IllegalArgumentException.class, () -> objAcc.deposit(0));
        assertEquals(21000, objAcc.getBalance());
    }


    @Test
    void testWithdraw() throws InsufficientFundsException {
        objAcc.withdraw(1500);

        assertEquals(19500, objAcc.getBalance());
    }

    @Test
    void testWithdrawExactBalance() throws InsufficientFundsException {
        objAcc.withdraw(21000);   // boundary: amount == balance must succeed

        assertEquals(0, objAcc.getBalance());
    }

    @Test
    void testInvalidWithdrawalNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> objAcc.withdraw(-350));
        assertEquals(21000, objAcc.getBalance());
    }

    @Test
    void testInvalidWithdrawalZeroAmount() {
        assertThrows(IllegalArgumentException.class, () -> objAcc.withdraw(0));
        assertEquals(21000, objAcc.getBalance());
    }

    @Test
    void testWithdrawalInsufficientFunds() {
        double amountToWithdraw = objAcc.getBalance() + 1;

        assertThrows(InsufficientFundsException.class,
                () -> objAcc.withdraw(amountToWithdraw));
        assertEquals(21000, objAcc.getBalance());   // unchanged after failure
    }

    @Test
    void testInsufficientFundsMessageContainsBalanceAndAmount() {
        InsufficientFundsException ex = assertThrows(InsufficientFundsException.class,
                () -> objAcc.withdraw(30000));

        assertTrue(ex.getMessage().contains("Insufficient Funds"));
        assertTrue(ex.getMessage().contains("21000.0"));
        assertTrue(ex.getMessage().contains("30000.0"));
    }


    @Test
    void testDisplayDetails() {

        String expected = "Account Holder   :   Jessica Jones\n"
                + "Account Number   :   CQ-98745612\n"
                + "Account Type     :   CHEQUE\n"
                + "Balance          :   " + String.format("%.2f", 21000.0);

        assertEquals(expected, objAcc.displayDetails());
    }
}