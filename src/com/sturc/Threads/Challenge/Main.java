package com.sturc.Threads.Challenge;


public class Main {

    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount(1000.0, "Account");

        new Thread(new Runnable() {
            @Override
            public void run() {
                bankAccount.deposit(300.0);
                bankAccount.withdraw(50.0);
                System.out.println("Thread 1 (deposit 300 and withdraw 50): " + bankAccount.getBalance());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                bankAccount.deposit(203.75);
                bankAccount.withdraw(100.0);
                System.out.println("Thread 2 (deposit 203.75 and withdraw 100): " + bankAccount.getBalance());

            }
        }).start();
    }
}
