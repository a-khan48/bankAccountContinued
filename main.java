import java.util.ArrayList;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<bankAccount> bankAccounts = new ArrayList<>();

        bankAccount Larry = new bankAccount("Larry", 5000, 0);
        bankAccount Mary = new bankAccount("Mary", 300, 1);
        bankAccounts.add(Larry);
        bankAccounts.add(Mary);

        System.out.println("Welcome to Bank of America Chase Wells Fargo Wachovia. How can we help you today?");
        System.out.println("Are you an existing customer? (-1 to exit)");
        System.out.println("1.Yes");
        System.out.println("2.No");

        int choice = Integer.parseInt(scanner.nextLine());
        while (true) {
            if (choice == -1) {
                break;
            }
            if (choice == 1) {
                System.out.println("Welcome valued BofACWFW Customer.");
                mainMenu(bankAccounts);
                break;
            }
            if (choice == 2) {
                bankAccount newAccount = new bankAccount();
                newAccount.setAcctNumber(bankAccounts.size() + 1);
                bankAccounts.add(newAccount);
                mainMenu(bankAccounts);
                break;
            }
            if (choice!= 1 && choice!=2 && choice!=-1){
                System.out.println("Invalid choice, Please try again later!");
                break;
            }
        }

    }
    public static void mainMenu(ArrayList<bankAccount> accounts){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your account number: ");
        int currentAccount = Integer.parseInt(scanner.nextLine());

        System.out.println("Welcome back, " + accounts.get(currentAccount).getUserAccountName());
        System.out.println("What would you like to do?");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check balance");
        System.out.println("4. Make a transfer to another account");
        System.out.println("0. Exit");
        int selected = Integer.parseInt(scanner.nextLine());
        switch(selected) {
            case 1:
                double balance = accounts.get(currentAccount).getAcctBalance();
                System.out.println("Your account balance is: " + balance);
                break;
            case 2:
                System.out.println("How much do you want to withdraw? ");
                double amount = scanner.nextDouble();
                double currentBalance = accounts.get(currentAccount).getAcctBalance();
                if(currentBalance < amount){
                    System.out.println("Insufficient funds!");
                    break;
                }
                System.out.println("Your current balance is: " + currentBalance);
                accounts.get(currentAccount).withdrawal(amount);
                currentBalance = accounts.get(currentAccount).getAcctBalance();
                System.out.println("Your balance after withdrawal is: " + currentBalance);
                break;
            case 3:
                System.out.println("How much amount do you want to deposit?");
                double depositAmt = scanner.nextDouble();
                double userBalance = accounts.get(currentAccount).getAcctBalance();
                System.out.println("The Current balance in your account is " + userBalance);
                accounts.get(currentAccount).deposit(depositAmt);
                userBalance = accounts.get(currentAccount).getAcctBalance();
                System.out.println("The balance after deposit in your account is " + userBalance);
                break;
            case 4:
                System.out.println("Provide account number you wish to transfer to.");
                int toAccount = Integer.parseInt(scanner.nextLine());
                if(toAccount == currentAccount){
                    System.out.println("You cannot do this.");
                    break;
                }

                if (toAccount <= accounts.size()) {
                    System.out.println(accounts.get(toAccount).toString());
                    System.out.println("Enter transfer amount: ");
                    double transferAmount = scanner.nextDouble();
                    double currentAccountBalance = accounts.get(currentAccount).getAcctBalance();
                    if(transferAmount > currentAccountBalance){
                        System.out.println("Insufficient funds.");
                    }else {
                        System.out.println("Your account balance before the transfer :" + currentAccountBalance);
                        accounts.get(currentAccount).transfer(accounts.get(toAccount), transferAmount);
                        System.out.println(accounts.get(toAccount).toString());
                        System.out.println(accounts.get(currentAccount).toString());
                    }
                    break;
                }

            default:
                System.out.println("ERROR: Invalid option.");
                break;
        }


    }
}