package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Creating object for savingsAccount and initializing the parameters. This will be gone to the constructors
        SavingsAccount savings = new SavingsAccount("SA001", "John Doe",
                1000.0, 0.05, 5000.0, 0.02);

        //Creating object for checkingAccount and initializing the parameters. This will be gone to the constructors
        Checking checking = new Checking("CA001", "Jane Doe",
                2000.0, 10000.0, 500.0);

        // Printing Initial balances of both accounts.
        System.out.println("Initial balances:");
        System.out.println("Savings (John Doe): $" + savings.getBalance());
        System.out.println("Checking (Jane Doe): $" + checking.getBalance());

        // Transfer money from checking to Savings
        System.out.println("\nTransferring $500 from Checking to Savings...");
        if (checking.transfer(savings, 500.0)) {
            System.out.println("Transfer successful!");
        }
        //Printing balances after transfer
        System.out.println("\nBalances after transfer:");
        System.out.println("Savings: $" + savings.getBalance());
        System.out.println("Checking: $" + checking.getBalance());

        // Add interest to savings
        System.out.println("\nAdding interest to Savings (5% rate)...");
        savings.addInterest();
        System.out.println("Savings after interest: $" + savings.getBalance());

        // Deduct tax from savings
        System.out.println("\nDeducting tax from Savings (2% rate)...");
        savings.deductTax();
        System.out.println("Savings after tax: $" + savings.getBalance());

        // withdrawal from checking with overdraft
        System.out.println("\nAttempting to withdraw $2000 from Checking...");
        if (checking.withdraw(2000.0)) {
            System.out.println("Withdrawal successful!");
        }
        System.out.println("Checking final balance: $" + checking.getBalance());
    }
}