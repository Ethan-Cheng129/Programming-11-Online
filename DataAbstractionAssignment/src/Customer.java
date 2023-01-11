import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits = new ArrayList<Deposit>();
    private ArrayList<Withdraw> withdraws = new ArrayList<Withdraw>();
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    Customer(){
        this.name = "No Name";
        this.savingBalance = 0.0;
        this.accountNumber = 0;
        this.checkBalance = 0.0;

    }

    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        this.name = name;
        this.accountNumber = accountNumber;
        this.checkBalance = checkDeposit;
        this.savingBalance = savingDeposit;
    }
    // Requires: Double, Date and String
    // Modifies: this, deposits
    // Effects: Adds to balance and returns balance
    public double deposit(double amt, Date date, String account) {
        if (account.equals(CHECKING)) {
            if (amt > 0) {
                checkBalance = checkBalance + amt;
                Deposit deposit = new Deposit(amt, date, account, checkBalance);
                deposits.add(deposit);
            }
            return checkBalance;
        } else {
            if (amt > 0) {
                savingBalance = savingBalance + amt;
                Deposit deposit = new Deposit(amt, date, account, savingBalance);
               deposits.add(deposit);
            }
            return savingBalance;
        }
    }
    // Requires: nothing
    // Modifies: nothing
    // Effects: returns savingBalance

    public double getSavingBalance(){

        return savingBalance;
    }
    // Requires: nothing
    // Modifies: nothing
    // Effects: returns checkingBalance

    public double getCheckingBalance(){

        return checkBalance;
    }
    // Requires: nothing
    // Modifies: nothing
    // Effects: returns deposits.size()

    public int getDepositsListSize(){

        return  deposits.size();
    }
    // Requires: nothing
    // Modifies: nothing
    // Effects: returns withdraws.size()

    public List<Withdraw> getWithdrawList(){

        return  Collections.unmodifiableList(withdraws);
    }


    // Requires: Double, Date and String
    // Modifies: this, withdraw
    // Effects: Removes from balance and returns balance

    public double withdraw(double amt, Date date, String account){
        if (account.equals(CHECKING)) {
            if (amt > 0) {
                if (checkOverdraft(amt, account) == false) {
                    checkBalance = checkBalance - amt;
                    Withdraw withdraw = new Withdraw(amt, date, account, checkBalance);
                    withdraws.add(withdraw);
                }
                else {
                    Withdraw overdraft = new Withdraw(amt, date, account ,checkBalance);
                    System.out.println("You have insufficient funds.");
                }
            }
            return checkBalance;

        } else {
            if (amt > 0){
                if (checkOverdraft(amt, account) == false){
                    savingBalance = savingBalance - amt;
                    Withdraw withdraw = new Withdraw(amt, date, account, savingBalance);
                    withdraws.add(withdraw);
                }
                else {
                    Withdraw overdraft = new Withdraw(amt, date, account ,savingBalance);
                    System.out.println("You have insufficient funds.");
                }
            }
            return savingBalance;
        }
    }
    // Requires: double and String
    // Modifies: nothing
    // Effects: Checks if there is an overdraft. Returns boolean
    public boolean checkOverdraft(double amt, String account){
        if (account.equals(CHECKING)) {
            if (amt > checkBalance) {
                return true;
            }
            return false;
        } else {
            if (amt > savingBalance) {
                return true;
            }
            return false;
        }
    }

    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

}
