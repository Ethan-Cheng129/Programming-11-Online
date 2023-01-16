import org.junit.Test;
import org.junit.Before;


import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class CustomerTest {
    Customer customer;

    @Before
    public void setup() {
        customer = new Customer();
    }

    //Test: Deposit positive amount of money into savings
    @Test
    public void testDepositSavingsAccount() {
        double balance = customer.deposit(10.00, new Date(122, 11, 25, 4, 16, 17), Customer.SAVING);
        double saveBalance = customer.getSavingBalance();
        int deposits = customer.getDepositsListSize();
        double expected = 10.0;
        int expectedlistsize = 1;

        assertEquals(expected,balance, 0.001);
        assertEquals(expected,saveBalance, 0.001);
        assertEquals(expectedlistsize,deposits);
    }

    // Test: Deposit positive amount of money into checking
    @Test
    public void testDepositCheckingAccount(){
        double checkingBalance = customer.deposit(10.00, new Date(122, 11, 25, 4, 16, 17), Customer.CHECKING);
        double checkBalance = customer.getCheckingBalance();
        int deposits = customer.getDepositsListSize();
        double expected = 10.0;
        int expectedlistsize = 1;

        assertEquals(expected,checkingBalance, 0.001);
        assertEquals(expected,checkBalance, 0.001);
        assertEquals(expectedlistsize,deposits);
    }

    // Test: Deposit negative amount of money into savings
    @Test
    public void testDepositNegativeSavingsAccount(){
        double savingBalance = customer.deposit(-10.00, new Date(122, 11, 25, 4, 16, 17), Customer.SAVING);
        double saveBalance = customer.getSavingBalance();
        int deposits = customer.getDepositsListSize();
        double expected = 0.0;
        int expectedlistsize = 0;

        assertEquals(expected,savingBalance, 0.001);
        assertEquals(expected,saveBalance, 0.001);
        assertEquals(expectedlistsize,deposits);
    }

    // Test: Deposit negative amount of money into checking
    @Test
    public void testDepositNegativeCheckingAccount() {
        double checkingBalance = customer.deposit(-10.00, new Date(122, 11, 25, 4, 16, 17), Customer.CHECKING);
        double checkBalance = customer.getCheckingBalance();
        int deposits = customer.getDepositsListSize();
        double expected = 0.0;
        int expectedlistsize = 0;

        assertEquals(expected,checkingBalance, 0.001);
        assertEquals(expected,checkBalance, 0.001);
        assertEquals(expectedlistsize,deposits);
    }

    // Test: Deposit nothing into savings
    @Test
    public void testDepositZeroSavingsAccount(){
        double savingBalance = customer.deposit(0.0, new Date(122, 11, 25, 4, 16, 17), Customer.SAVING);
        double saveBalance = customer.getSavingBalance();
        int deposits = customer.getDepositsListSize();
        double expected = 0.0;
        int expectedlistsize = 0;

        assertEquals(expected,savingBalance, 0.001);
        assertEquals(expected,saveBalance, 0.001);
        assertEquals(expectedlistsize,deposits);
    }

    // Test: Deposit nothing into checking
    @Test
    public void testDepositZeroCheckingAccount() {
        double checkingBalance = customer.deposit(0.0, new Date(122, 11, 25, 4, 16, 17), Customer.CHECKING);
        double checkBalance = customer.getCheckingBalance();
        int deposits = customer.getDepositsListSize();
        double expected = 0.0;
        int expectedlistsize = 0;

        assertEquals(expected,checkingBalance, 0.001);
        assertEquals(expected,checkBalance, 0.001);
        assertEquals(expectedlistsize,deposits);
    }

    // Test: Withdraw positive amount of money from savings
    @Test
    public void testWithdrawalSavingsAccount() {
        double balance = customer.deposit(20.00, new Date(122, 10, 25, 4, 16, 17), Customer.SAVING);
        double expectedBalanceAfterDeposit = 20.0;
        assertEquals(expectedBalanceAfterDeposit, balance, 0.01);


        double savingBalance = customer.withdraw(10.00, new Date(122, 11, 25, 4, 16, 17), Customer.SAVING);
        double balanceOfSaving = customer.getSavingBalance();
        double expected = 10.00;

        List<Withdraw> withdrawList = customer.getWithdrawList();
        Withdraw withdraw = withdrawList.get(0);

        int expectedlistsize = 1;

        assertEquals(expected,savingBalance, 0.001);
        assertEquals(expectedlistsize,withdrawList.size());
        assertEquals(expected,balanceOfSaving,0.001);
        assertEquals("Withdrawal of: $10.00 Date: Sun Dec 25 04:16:17 PST 2022 from account: Saving Current Balance in Saving is: $10.0", withdraw.toString());
    }

    // Test: Withdraw positive amount of money from checking
    @Test
    public void testWithdrawalCheckingAccount() {
        double balance = customer.deposit(20.00, new Date(122, 10, 25, 4, 16, 17), Customer.CHECKING);
        double expectedBalanceAfterDeposit = 20.0;
        assertEquals(expectedBalanceAfterDeposit, balance, 0.01);


        double checkingBalance = customer.withdraw(10.00, new Date(122, 11, 25, 4, 16, 17), Customer.CHECKING);
        double balanceOfChecking = customer.getCheckingBalance();
        double expected = 10.00;

        List<Withdraw> withdrawList = customer.getWithdrawList();
        Withdraw withdraw = withdrawList.get(0);

        int expectedlistsize = 1;

        assertEquals(expected,checkingBalance, 0.001);
        assertEquals(expectedlistsize,withdrawList.size());
        assertEquals(expected,balanceOfChecking,0.001);
        assertEquals("Withdrawal of: $10.00 Date: Sun Dec 25 04:16:17 PST 2022 from account: Checking Current Balance in Checking is: $10.0", withdraw.toString());
    }

    // Test: Withdraw nothing from savings account
    @Test
    public void testWithdrawalZeroSavingsAccount() {
        double balance = customer.deposit(20.00, new Date(122, 10, 25, 4, 16, 17), Customer.SAVING);
        double expectedBalanceAfterDeposit = 20.0;
        assertEquals(expectedBalanceAfterDeposit, balance, 0.01);


        double savingBalance = customer.withdraw(0.0, new Date(122, 11, 25, 4, 16, 17), Customer.SAVING);
        double balanceOfSaving = customer.getSavingBalance();
        double expected = 20.00;

        List<Withdraw> withdrawList = customer.getWithdrawList();

        int expectedlistsize = 0;

        assertEquals(expected,savingBalance, 0.001);
        assertEquals(expectedlistsize,withdrawList.size());
        assertEquals(expected,balanceOfSaving,0.001);
    }

    // Test: Withdraw nothing from checking account
    @Test
    public void testWithdrawalZeroCheckingAccount() {
        double balance = customer.deposit(20.00, new Date(122, 10, 25, 4, 16, 17), Customer.CHECKING);
        double expectedBalanceAfterDeposit = 20.0;
        assertEquals(expectedBalanceAfterDeposit, balance, 0.01);


        double checkingBalance = customer.withdraw(0.0, new Date(122, 11, 25, 4, 16, 17), Customer.CHECKING);
        double balanceOfChecking = customer.getCheckingBalance();
        double expected = 20.0;

        List<Withdraw> withdrawList = customer.getWithdrawList();

        int expectedlistsize = 0;

        assertEquals(expected,checkingBalance, 0.001);
        assertEquals(expectedlistsize,withdrawList.size());
        assertEquals(expected,balanceOfChecking,0.001);
    }

    // Test: Withdraw negative amount of money from savings
    @Test
    public void testWithdrawalNegativeSavingsAccount() {
        double balance = customer.deposit(20.00, new Date(122, 10, 25, 4, 16, 17), Customer.SAVING);
        double expectedBalanceAfterDeposit = 20.0;
        assertEquals(expectedBalanceAfterDeposit, balance, 0.01);


        double savingBalance = customer.withdraw(-10.00, new Date(122, 11, 25, 4, 16, 17), Customer.SAVING);
        double balanceOfSaving = customer.getSavingBalance();
        double expected = 20.0;

        List<Withdraw> withdrawList = customer.getWithdrawList();

        int expectedlistsize = 0;

        assertEquals(expected,savingBalance, 0.001);
        assertEquals(expectedlistsize,withdrawList.size());
        assertEquals(expected,balanceOfSaving,0.001);
    }

    // Test: Withdraw negative amount of money from checking
    @Test
    public void testWithdrawalNegativeCheckingAccount() {
        double balance = customer.deposit(20.00, new Date(122, 10, 25, 4, 16, 17), Customer.CHECKING);
        double expectedBalanceAfterDeposit = 20.0;
        assertEquals(expectedBalanceAfterDeposit, balance, 0.01);


        double checkingBalance = customer.withdraw(-10.00, new Date(122, 11, 25, 4, 16, 17), Customer.CHECKING);
        double balanceOfChecking = customer.getCheckingBalance();
        double expected = 20.0;

        List<Withdraw> withdrawList = customer.getWithdrawList();

        int expectedlistsize = 0;

        assertEquals(expected,checkingBalance, 0.001);
        assertEquals(expectedlistsize,withdrawList.size());
        assertEquals(expected,balanceOfChecking,0.001);
    }

    // Test: Check for overdrafts in checking
    @Test
    public void testOverdraftCheckingAccount() {
        double balance = customer.deposit(20.00, new Date(122, 10, 25, 4, 16, 17), Customer.CHECKING);
        double expectedBalanceAfterDeposit = 20.0;
        assertEquals(expectedBalanceAfterDeposit, balance, 0.01);


        double checkingBalance = customer.withdraw(30.00, new Date(122, 11, 25, 4, 16, 17), Customer.CHECKING);
        double balanceOfChecking = customer.getCheckingBalance();
        double expected = 20.0;

        List<Withdraw> withdrawList= customer.getWithdrawList();

        int expectedlistsize = 0;
        boolean overdrafts = customer.checkOverdraft(30.00,Customer.CHECKING);

        assertEquals(expected,checkingBalance, 0.001);
        assertEquals(expectedlistsize,withdrawList.size());
        assertEquals(expected,balanceOfChecking,0.001);
        assertEquals(overdrafts, true);

    }

    // Test: Check for overdrafts in savings
    @Test
        public void testOverdraftSavingsAccount(){
            double balance = customer.deposit(20.00, new Date(122, 10, 25 , 4 ,16,17), Customer.SAVING);
        double expectedBalanceAfterDeposit = 20.0;
        assertEquals(expectedBalanceAfterDeposit, balance, 0.01);

        double savingBalance = customer.withdraw(30.00, new Date(122, 10 , 25 ,4 ,16 , 17),Customer.SAVING);
        double balanceOfSaving = customer.getSavingBalance();
        double expected = 20.0;

        List<Withdraw> withdrawList = customer.getWithdrawList();

        int expectedlistsize = 0;
        boolean overdrafts = customer.checkOverdraft(30.00,Customer.SAVING);

        assertEquals(expected, savingBalance, 0.001);
        assertEquals(expectedlistsize, withdrawList.size());
        assertEquals(expected,balanceOfSaving,0.001);
        assertEquals(overdrafts, true);
    }

    // Test: Deposit an amount with more than two decimal places. Deposit method should ignore digits after two decimal places.
    @Test
    public void testDepositMoreThanTwoDecimalPlaceSavingsAccount() {
        double balance = customer.deposit(10.5645647, new Date(122, 11, 25, 4, 16, 17), Customer.SAVING);
        double saveBalance = customer.getSavingBalance();
        int deposits = customer.getDepositsListSize();
        double expected = 10.56;
        int expectedlistsize = 1;

        assertEquals(expected,balance, 0.001);
        assertEquals(expected,saveBalance, 0.001);
        assertEquals(expectedlistsize,deposits);
    }

    // Test: Deposit an amount with more than two decimal places. Deposit method should ignore digits after two decimal places.
    @Test
    public void testDepositMoreThanTwoDecimalPlaceCheckingAccount() {
        double balance = customer.deposit(10.5645647, new Date(122, 11, 25, 4, 16, 17), Customer.CHECKING);
        double checkBalance = customer.getCheckingBalance();
        int deposits = customer.getDepositsListSize();
        double expected = 10.56;
        int expectedlistsize = 1;

        assertEquals(expected,balance, 0.001);
        assertEquals(expected,checkBalance, 0.001);
        assertEquals(expectedlistsize,deposits);
    }

    // Test: Withdraw an amount with more than two decimal places. Withdraw method should ignore digits after two decimal places.
    @Test
    public void testWithdrawalMoreThanTwoDecimalPlaceSavingsAccount() {
        double balance = customer.deposit(20.00, new Date(122, 10, 25, 4, 16, 17), Customer.SAVING);
        double expectedBalanceAfterDeposit = 20.0;
        assertEquals(expectedBalanceAfterDeposit, balance, 0.01);


        double savingBalance = customer.withdraw(10.645564, new Date(122, 11, 25, 4, 16, 17), Customer.SAVING);
        double balanceOfSaving = customer.getSavingBalance();
        double expected = 9.36;

        List<Withdraw> withdrawList = customer.getWithdrawList();
        Withdraw withdraw = withdrawList.get(0);

        int expectedlistsize = 1;

        assertEquals(expected,savingBalance, 0.001);
        assertEquals(expectedlistsize,withdrawList.size());
        assertEquals(expected,balanceOfSaving,0.001);
        assertEquals("Withdrawal of: $10.64 Date: Sun Dec 25 04:16:17 PST 2022 from account: Saving Current Balance in Saving is: $9.36", withdraw.toString());
    }

    // Test: Withdraw an amount with more than two decimal places. Withdraw method should ignore digits after two decimal places.
    @Test
    public void testWithdrawalMoreThanTwoDecimalPlaceCheckingAccount() {
        double balance = customer.deposit(20.00, new Date(122, 10, 25, 4, 16, 17), Customer.CHECKING);
        double expectedBalanceAfterDeposit = 20.0;
        assertEquals(expectedBalanceAfterDeposit, balance, 0.01);


        double checkingBalance = customer.withdraw(10.466876, new Date(122, 11, 25, 4, 16, 17), Customer.CHECKING);
        double balanceOfChecking = customer.getCheckingBalance();
        double expected = 9.54;

        List<Withdraw> withdrawList = customer.getWithdrawList();
        Withdraw withdraw = withdrawList.get(0);

        int expectedlistsize = 1;

        assertEquals(expected,checkingBalance, 0.001);
        assertEquals(expectedlistsize,withdrawList.size());
        assertEquals(expected,balanceOfChecking,0.001);
        assertEquals("Withdrawal of: $10.46 Date: Sun Dec 25 04:16:17 PST 2022 from account: Checking Current Balance in Checking is: $9.54", withdraw.toString());
    }

}