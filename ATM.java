import java.util.Scanner;

// Class representing the user's bank account
class BankAccount {
    private double bal;

    public BankAccount(double initialBalance) {
        this.bal = initialBalance;
    }

    public double getBalance() {
        return bal;
    }

    public void deposit(double amnt) {
        if (amnt > 0) {
            bal += amnt;
            System.out.println("Successfully deposited: $" + amnt);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= bal) {
            bal -= amount;
            System.out.println("Successfully withdrew: $" + amount);
            return true;
        } else if (amount > bal) {
            System.out.println("Insufficient balance.");
            return false;
        } else {
            System.out.println("Invalid withdrawal amount.");
            return false;
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: $" + bal);
    }
}

// Class representing the ATM machine
class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void start() {
        Scanner scan = new Scanner(System.in);
        int opt;

        do {
            System.out.println("\nATM Interface");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            opt = scan.nextInt();

            switch (opt) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scan.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scan.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (opt != 4);

        scan.close();
    }
}

// Main class to run the program
public class Main {
    public static void main(String[] args) {
        // Create a bank account with an initial balance of $1000
        BankAccount acc = new BankAccount(1000.0);

        // Create the ATM with the bank account
        ATM at = new ATM(acc);

        // Start the ATM interface
        at.start();
    }
}
