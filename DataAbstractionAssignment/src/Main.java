import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer("Kyle", 20224455, 45, 45);
        Scanner scanner = new Scanner(System.in);
        String input = "";



        do {
            System.out.println("=======================================================");
            System.out.println("=          Welcome to the Bank of Walmart             =");
            System.out.println("=======================================================");

            System.out.println(" Would you like to withdraw or deposit?");
            System.out.println(" To exit, enter x");

            input = scanner.nextLine();

            if (input.equalsIgnoreCase("Withdraw")) {
                // Withdraw from an account
                do {
                    // Keep asking for account type until input is either Checking or Saving
                    System.out.println("Which account would you like to withdraw from?");
                    System.out.println("Checking or Saving?");
                    input = scanner.nextLine();
                    if ("x".equalsIgnoreCase(input))
                        return;
                } while (!input.equalsIgnoreCase(Customer.CHECKING) && !input.equalsIgnoreCase(Customer.SAVING));

                // save the account type as Constant
                String account = "";
                if (input.equalsIgnoreCase(Customer.CHECKING)) {
                    account = Customer.CHECKING;
                } else {
                    account = Customer.SAVING;
                }
                // Ask user how much they would like to withdraw
                System.out.println("How much money would you like to withdraw?");
                double amt = Double.parseDouble(scanner.nextLine());

                // Withdraw the money and show withdrawal history
                double balance = customer.withdraw(amt, Date.from(Instant.now()), account);
                System.out.println("The balance in your " + account + " account is $" + balance);
                customer.displayWithdraws();
            } else if (input.equalsIgnoreCase("Deposit")) {
                // Deposit to an account
                do {
                    // Keep asking for account type until input is either Checking or Saving
                    System.out.println("Which account would you like to deposit to?");
                    System.out.println("Checking or Saving?");
                    input = scanner.nextLine();

                    if ("x".equalsIgnoreCase(input))
                        return;
                } while (!input.equalsIgnoreCase(Customer.CHECKING) && !input.equalsIgnoreCase(Customer.SAVING));
                // Save account type as constant
                String account = "";
                if (input.equalsIgnoreCase(Customer.CHECKING)) {
                    account = Customer.CHECKING;
                } else {
                    account = Customer.SAVING;
                }
                // Ask the user how much they would like to deposit
                System.out.println("How much money would you like to deposit?");
                double amt = Double.parseDouble(scanner.nextLine());

                // Deposit the money and show deposit history
                double balance = customer.deposit(amt, Date.from(Instant.now()), account);
                System.out.println("The balance in your " + account + " account is $" + balance);
                customer.displayDeposits();

            } else if (!input.equalsIgnoreCase("x")) {
                // Tells user to input a valid option
                System.out.println("Invalid option. Try again.");
            }
            // Program ends when user enters "x"
        } while (!input.equalsIgnoreCase("x"));
    }
}

