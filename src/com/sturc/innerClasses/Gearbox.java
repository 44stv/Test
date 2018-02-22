package com.sturc.innerClasses;

import java.util.ArrayList;

public class Gearbox {

    private ArrayList<Gear> gears;
    private int maxGears;
    private int currentGear = 0;
    private boolean clutchIsIn;

    public Gearbox(int maxGears) {
        this.maxGears = maxGears;
        this.gears = new ArrayList<>();
        Gear neutral = new Gear (0, 0.0);
        this.gears.add(neutral);
    }

    public void operateClutch(boolean in){
        this.clutchIsIn = in;
    }

    public void addGear(int number, double ratio){
        if ((number > 0) && (number <= maxGears)){
            this.gears.add(new Gear(number, ratio));
        }
    }

    public void changeGear (int gearNumber){
        if ((gearNumber >= 0) && (gearNumber <= maxGears) && this.clutchIsIn) {
            this.currentGear = gearNumber;
            System.out.println("Gear is changed to " + gearNumber);
        }else System.out.println("Gear isn`t changed.");
    }

    public double wheelSpeed (int revs){
        if (clutchIsIn) {
            System.out.println("mistake");
            return 0.0;
        }
        return revs * gears.get(currentGear).getGearRatio();
    }

    private class Gear {
        private int gearNumber;
        private double gearRatio;

        Gear(int gearNumber, double gearRatio) {
            this.gearNumber = gearNumber;
            //Gearbox.this.currentGear = currentGear;
            this.gearRatio = gearRatio;
        }

        public double driveSpeed (int revs){
            return revs*(this.gearRatio);
        }

        public double getGearRatio() {
            return gearRatio;
        }

        public void setGearRatio(double gearRatio) {
            this.gearRatio = gearRatio;
        }
    }
}
