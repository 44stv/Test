package com.sturc.Threads.Livelock;

import java.util.concurrent.atomic.AtomicInteger;

public class Worker {

    private String name;
    private boolean active;

    public Worker(String name, boolean active) {
        this.name = name;
        this.active = active;
    }

    public synchronized void work(SharedResource sharedResource, Worker otherWorker) {
        while (active) {
            if (sharedResource.getOwner() != this) {
                try {
                    wait(10);
                } catch (InterruptedException e) {

                }
                continue;
            }

            if (otherWorker.isActive()) {
                System.out.println(getName() + ": give the resources to the worker " + otherWorker.getName());
                sharedResource.setOwner(otherWorker);
                continue;
            }

            System.out.println(getName() + ": working on a common resource.");
            active = false;
            sharedResource.setOwner(otherWorker);
        }
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }
}
