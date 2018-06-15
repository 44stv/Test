package com.sturc.Abstraction;

public abstract class Bird extends Animal implements CanFly{

    public Bird(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " bird eating.");
    }

    @Override
    public void breath() {
        System.out.println("breath.");

    }

    @Override
    public void fly() {
        System.out.println(getName() + " can fly.");
    }
}
