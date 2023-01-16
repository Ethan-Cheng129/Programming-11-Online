import java.text.DecimalFormat;
import java.util.Date;

public class Deposit {

    // This is to format the withdrawal amount to two decimal places.
    private static final DecimalFormat df = new DecimalFormat("0.00");

    private double amount;
    private Date date;
    private String account;
    private double balance;

    Deposit(double amount, Date date, String account, double balance){
        this.amount = amount;
        this.date = date;
        this.account = account;
        this.balance = balance;
    }

    // Requires nothing
    // Modifies nothing
    // Effects returns deposit amount, date, account and current balance
    public String toString(){
        return "Deposit of: $" + df.format(amount) + " Date: " + date + " into account: " + account + " Current Balance in " + account + " is: $" + balance;
    }
}
