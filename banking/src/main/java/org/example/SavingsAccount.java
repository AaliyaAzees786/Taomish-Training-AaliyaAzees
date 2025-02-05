package org.example;

public class SavingsAccount extends Account implements Interest,Taxable,Transferable {
    //Declaration
    private final double interestRate;
    private final double transferLimit;
    private final double taxRate;

    // Constructor
    public SavingsAccount(String accountNumber, String accountHolder,
                          double initialBalance, double interestRate,
                          double transferLimit, double taxRate) {
        super(accountNumber, accountHolder, initialBalance);//Super used for inheriting from parent class.
        this.interestRate = interestRate;
        this.transferLimit = transferLimit;
        this.taxRate = taxRate;
    }

    //Overriding
    @Override
    public boolean withdraw(double amount) {
        if (amount <= balance && amount > 0) {
            balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }

    @Override
    public void addInterest() {
        balance += calculateInterest();
    }

    @Override
    public double calculateTax() {
        return balance * taxRate;
    }

    @Override
    public void deductTax() {
        balance -= calculateTax();
    }

    @Override
    public boolean transfer(Account recipient, double amount) {
        if (amount <= transferLimit && withdraw(amount)) {
            return recipient.deposit(amount);
        }
        return false;
    }

    @Override
    public double getTransferLimit() {
        return transferLimit;
    }
}
