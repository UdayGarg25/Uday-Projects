import java.util.*;
public class ATMinterface {
    public static void main(String[] args) {
        ATM obj = new ATM();
    }
}
class ATM {
    int Pin = 6545;
    float Balance;
    ATM() {
        System.out.println("Enter Your Pin : ");
        Scanner sc = new Scanner(System.in);
        int enteredPin;
        do {
            enteredPin = sc.nextInt();
            if(enteredPin == Pin) {
                menu();
            }
            else {
                System.out.println("Enter a Valid PIN");
            }
        }
        while(enteredPin!=Pin);
    }
    public void menu() {
        System.out.println("Enter Your Choice : ");
        System.out.println("1. Check A/C Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Exit");
        Scanner sc = new Scanner(System.in);
        int opt = sc.nextInt();
        if(opt == 1) {
            checkBalance();
        }
        else if(opt == 2) {
            withdrawMoney();
        }
        else if(opt == 3) {
            depositMoney();
        }
        else if(opt == 4) {
            return;
        }
        else {
            System.out.println("Enter a valid Choice");
        }
    }
    public void checkBalance() {
        System.out.println("Balance :"+Balance);
        menu();
    }
    public void withdrawMoney() {
        System.out.println("Enter amount to withdraw : ");
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        if(amount > Balance) {
            System.out.println("Insufficient Balance!!!");
        }
        else {
            Balance = Balance - amount;
            System.out.println("Money Withdrawl Successfully");
        }
        menu();
    }
    public void depositMoney() {
        System.out.println("Enter amount to Deposit : ");
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        Balance = Balance + amount;
        System.out.println("Money Deposited Successfully");
        menu();
    }
}
