package com.sturc.Collections;

public class Main {

    public static void main(String[] args) {

        Theatre theatre = new Theatre("Theatre", 8, 12);
        //theatre.getSeats();


        if (theatre.reserveSeat("D12")) {
            System.out.println("Please pay.");
        } else {
            System.out.println("Seat is already reserved.");
        }

    }
}
