package org.example;

class Checking extends Account implements Transferable {
    //Declaration
    private double transferLimit;
    private double overdraftLimit;

    //Constructor for the checking class
    public Checking(String accountNumber, String accountHolder, double initialBalance, double transferLimit, double overdraftLimit) {
        super(accountNumber, accountHolder, initialBalance);//Super used so that these three variables are initialized in parent class.
        this.transferLimit = transferLimit;
        this.overdraftLimit = overdraftLimit;
    }

    //Overriding done for each methods in all the interfaces and abstract classes.
    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= -overdraftLimit) {
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
