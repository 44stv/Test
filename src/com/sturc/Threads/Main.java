package com.sturc.Threads;

import static com.sturc.Threads.ThreadColor.ANSI_GREEN;
import static com.sturc.Threads.ThreadColor.ANSI_PURPLE;
import static com.sturc.Threads.ThreadColor.ANSI_RED;

public class Main {
    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread.");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("==Another thread==");
        anotherThread.start();

        new Thread() {
            public void run() {
                System.out.println(ANSI_GREEN + "Hello from anonymous class thread.");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from anonymous class`s implementation of runnable class.");
                try {
                    anotherThread.join(1000);
                    System.out.println(ANSI_RED + "AnotherThread terminated or timed out, so runnable is running again.");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_RED + "Thread was interrupted ");
                }
            }
        });
        myRunnableThread.start();


        System.out.println(ANSI_PURPLE + "Hello again from the main thread.");


    }
}
