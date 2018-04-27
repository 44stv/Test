package com.sturc.Threads.ProducerConsumer;

import static com.sturc.Threads.ThreadColor.*;

import java.util.Random;
import java.util.concurrent.*;

import static com.sturc.Threads.ProducerConsumer.Main.EOF;

public class Main {

    public static final String EOF = "EOF";

    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(10);

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        MyProducer producer = new MyProducer(buffer, ANSI_WHITE);
        MyConsumer consumer1 = new MyConsumer(buffer, ANSI_WHITE);
        MyConsumer consumer2 = new MyConsumer(buffer, ANSI_WHITE);
        MyConsumer consumer3 = new MyConsumer(buffer, ANSI_WHITE);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);
        executorService.execute(consumer3);

        Callable<String> test = () -> {
            System.out.println(ANSI_WHITE + "Printed from callable class.");
            return "This is the callable result";
        };

        Future<String> future = executorService.submit(test);

        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            System.out.println("ExecutionException");
        } catch (InterruptedException e1) {
            System.out.println("Thread running the task was interrupted.");
        }

        executorService.shutdown();
    }
}


class MyProducer implements Runnable{

    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyProducer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        Random random = new Random();
        String[] nums = new String[10];

        for (int i = 1; i <= 10; i++) {
            nums[i-1] = "" + i;
        }

        for (String num : nums) {
            try {
                System.out.println(color + "Producer adding " + num);
                buffer.put(num);

                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted.");
            }
        }

        System.out.println(color + "Adding EOF and exiting.");
        try {
            buffer.put("EOF");
        } catch (InterruptedException e) {

        }
    }
}

class MyConsumer implements Runnable {

    private ArrayBlockingQueue<String> buffer;
    private String color;
    private static int number = 0;
    private int num;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
        num = ++number;
    }

    public void run () {

        while (true) {
            synchronized (buffer) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    if (buffer.peek().equals(EOF)) {
                        System.out.println(color + "Exiting.");
                        break;
                    } else {
                        System.out.println(color + "Consumer " + num + " removed " + buffer.take());
                    }
                } catch (InterruptedException e) {

                }
            }
        }
    }
}
