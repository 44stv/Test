package com.sturc.Collections;

import java.util.*;

public class Theatre {

    private final String name;
    private List<Seat> seats = new ArrayList<>();


    public Theatre(String name, int numRows, int seatPerRow) {
        this.name = name;

        int lastRow = 'A' + (numRows - 1);

        System.out.println("Available seats:");
        for (char row = 'A'; row <= lastRow; row++){
            System.out.print(row + ": ");
            for (int seatNum = 1; seatNum <= seatPerRow; seatNum++){
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
                System.out.print(seat.getSeatNumber() + " ");
            }
            System.out.println();
        }

    }

    public boolean reserveSeat(String seatNumber) {
        int low = 0;
        int high = seats.size()-1;

        while (low <= high) {
            System.out.print(".");
            int mid = (low + high) / 2;
            Seat midVal = seats.get(mid);
            int cmp = midVal.getSeatNumber().compareTo(seatNumber);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return seats.get(mid).reserve();
            }
        }
        System.out.println("There is no seat " + seatNumber);
        return false;
    }

    //for testing
    public void getSeats() {
        for (Seat seat : seats) {
            System.out.println(seat.getSeatNumber());
        }
    }

    public String getName() {
        return name;
    }

    private class Seat implements Comparable<Seat>{

        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        public boolean reserve() {
            if (!this.reserved){
                this.reserved = true;
                System.out.println("Seat №" + seatNumber + " reserved.");
                return true;
            } else {
                return false;
            }
        }

        public boolean cancel() {
            if (this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat №" + seatNumber + " cancelled.");
                return true;
            } else {
                return false;
            }
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public String getSeatNumber() {
            return seatNumber;
        }
    }


}
