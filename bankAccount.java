import java.util.Scanner;
public class bankAccount {
    private String accountName;
    private double acctBalance;
    private int acctNumber;

    public bankAccount(String accountName, double acctBalance, int accountNumber){
        this.accountName = accountName;
        this.acctBalance = acctBalance;
        this.acctNumber = acctNumber;
    }


    public bankAccount() {
        Scanner input = new Scanner(System.in);
        System.out.println("NEW USER.");
        System.out.println("Add a name for the account: ");
        String name = input.nextLine();
        System.out.println("How much will you add for your starting balance? ");
        double balance = input.nextDouble();
        this.accountName = name;
        this.acctBalance = balance;

    }

    public void setAcctNumber(int num){
        this.acctNumber = num;
    }
    public String getUserAccountName() {
        return accountName;
    }

    public double getAcctBalance() {
        return acctBalance;
    }

    public void deposit(double depositAmt){
        acctBalance = acctBalance + depositAmt;
    }

    public  void withdrawal(double withdrawAmount){

        acctBalance -= withdrawAmount;
    }

    public void transfer(bankAccount acct, double amount){
        acctBalance -= amount;
        acct.acctBalance += amount;
    }

    @Override public String toString(){
       return "Account ID: " + acctNumber + " Account Name: "
               + accountName + " Account Balance: $" + acctBalance;

    }
}
