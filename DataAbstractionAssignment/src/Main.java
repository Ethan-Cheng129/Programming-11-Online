import java.sql.SQLOutput;
import java.time.Instant;
import java.util.Date;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Customer customer;
        customer = new Customer();
        Scanner scanner = new Scanner(System.in);
        String input = "";
        do {
            System.out.println("=======================================================");
            System.out.println("=          Welcome to the Bank of Walmart             =");
            System.out.println("=======================================================");
            System.out.println(" Would you like to withdraw or deposit?");
            System.out.println(" To exit, enter x");

            input = scanner.next();
            if (input.equalsIgnoreCase("Withdraw")) {

                do {
                    System.out.println("Which account would you like to withdraw from?");
                    System.out.println("Checking or Saving?");
                    input = scanner.next();
                } while(!input.equalsIgnoreCase(Customer.CHECKING) && !input.equalsIgnoreCase(Customer.SAVING));

                String account = "";
                if (input.equalsIgnoreCase(Customer.CHECKING)) {
                    account = Customer.CHECKING;
                } else {
                    account = Customer.SAVING;
                }
                System.out.println("How much money would you like to withdraw?");
                double amt = scanner.nextDouble();
                double balance = customer.withdraw(amt, Date.from(Instant.now()), account);
                System.out.println("The balance in your " + account + " account is $" + balance);
                customer.displayWithdraws();

            } else if (input.equalsIgnoreCase("Deposit")) {

                do {
                    System.out.println("Which account would you like to deposit to?");
                    System.out.println("Checking or Saving?");
                    input = scanner.next();
                } while(!input.equalsIgnoreCase(Customer.CHECKING)&& !input.equalsIgnoreCase(Customer.SAVING));

                String account = "";
                if (input.equalsIgnoreCase(Customer.CHECKING)){
                    account = Customer.CHECKING;
                } else {
                    account = Customer.SAVING;
                }
                System.out.println("How much money would you like to deposit?");
                double amt = scanner.nextDouble();
                double balance = customer.deposit(amt, Date.from(Instant.now()), account);
                System.out.println("The balance in your " + account + " account is $" + balance + ".");
                customer.displayDeposits();

            } else if (!input.equalsIgnoreCase("x")){
                System.out.println("Invalid option. Try again.");
            }

        } while (!input.equalsIgnoreCase("x"));
    }
}

