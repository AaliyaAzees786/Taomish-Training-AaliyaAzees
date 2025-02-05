package org.example;

interface Transferable{
    boolean transfer(Account recipient, double amount);
    double getTransferLimit();
}
