import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;
    private double balance;

    Withdraw(double amount, Date date, String account, double balance){
        this.amount = amount;
        this.date = date;
        this.account = account;
        this.balance = balance;
    }

    public String toString(){
        return "Withdrawal of: $" + amount + " Date: " + date + " from account: " + account + " Current Balance in " + account + " is: $" + balance;
    }
}
