package org.example;

abstract class Account {

    //Declaring all the variables(Protected variables used in same class, subclass in different package, same package).
    protected String accountNumber;
    protected String accountHolder;
    double balance;


    //Parameterized Constructor for Account class
    public Account(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    //Abstract Method declaration
    public abstract boolean withdraw(double amount);
    public abstract boolean deposit(double amount);

    //Defining abstract methods
    public double getBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}
