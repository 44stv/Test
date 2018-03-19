package com.sturc.UnitTesting;

import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount account;

    @org.junit.Before
    public void setup() {
        account = new BankAccount("Stas", "Stas", 1000.0, BankAccount.CHECKING);
        System.out.println("Running a test.");
    }

    @org.junit.Test
    public void deposit() {
        double balance = account.deposit(200.0, true);
        assertEquals(1200.0, balance, 0);
    }

    @org.junit.Test
    public void withdraw() {
        fail("Yet to be implemented");
    }

    @org.junit.Test
    public void getBalance_deposit() {
        account.deposit(200.0, true);
        assertEquals(1200.0, account.getBalance(), 0);
    }

    @org.junit.Test
    public void getBalance_withdraw() {
        account.withdraw(200.0, true);
        assertEquals(800.0, account.getBalance(), 0);
    }

    @org.junit.Test
    public void isChecking_true() {
        assertTrue("The account is not a checking account.", account.isChecking());
    }
}