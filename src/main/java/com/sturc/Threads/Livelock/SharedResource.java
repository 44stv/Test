package com.sturc.Threads.Livelock;

public class SharedResource {

    private Worker owner;

    public SharedResource(Worker worker) {
        this.owner = worker;
    }

    public Worker getOwner() {
        return owner;
    }

    public synchronized void setOwner(Worker owner) {
        this.owner = owner;
    }
}
