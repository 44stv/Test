package com.sturc.UnitTesting;

import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount account;
    private static int count;

    @org.junit.BeforeClass
    public static void beforeClass() {
        System.out.println("This executes before all test cases. Count = " + count++);
    }

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
    public void withdraw_branch() throws Exception {
        double balance = account.withdraw(600.0, true);
        assertEquals(400.0, balance, 0);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void withdraw_notBranch() throws Exception {
        account.withdraw(600.0, false);
    }

    @org.junit.Test
    public void getBalance_deposit() throws Exception {
        account.deposit(200.0, true);
        assertEquals(1200.0, account.getBalance(), 0);
    }

    @org.junit.Test
    public void getBalance_withdraw() throws Exception {
        account.withdraw(200.0, true);
        assertEquals(800.0, account.getBalance(), 0);
    }

    @org.junit.Test
    public void isChecking_true() {
        assertTrue("The account is not a checking account.", account.isChecking());
    }

    @org.junit.After
    public void teardown() {
        System.out.println("Count = " + count++);
    }

    @org.junit.AfterClass
    public static void afterClass() {
        System.out.println("This executes after all test cases. Count = " + count++);
    }
}