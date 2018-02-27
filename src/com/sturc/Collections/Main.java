package com.sturc.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Theatre theatre = new Theatre("Theatre", 8, 12);
        //theatre.getSeats();
        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats);
        printList(seatCopy);

        seatCopy.get(1).reserve();
        if (theatre.reserveSeat("A02")) {
            System.out.println("Pay for seat A02");
        } else {
            System.out.println("Seat already reserved.");
        }

        Collections.shuffle(seatCopy);
        System.out.println("Printing seatCopy");
        printList(seatCopy);

        System.out.println("Printing theatre.seats");
        printList(theatre.seats);

        Theatre.Seat minSeat = Collections.min(seatCopy);
        Theatre.Seat maxSeat = Collections.max(seatCopy);
        System.out.println("Min seat is " + minSeat.getSeatNumber());
        System.out.println("Max seat is "+ maxSeat.getSeatNumber());

        sortList(seatCopy);
        System.out.println("Printing sorted seatCopy");
        printList(seatCopy);

    }

    public static void printList(List<Theatre.Seat> list) {
        for (Theatre.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("=============================");
    }

    public static void sortList(List<? extends Theatre.Seat> list) {
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }
}
