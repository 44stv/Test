package com.sturc;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int size = 10;
        int [] testArray = new int[size];
        Random gen = new Random();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i <= size-1; i++) testArray[i] = gen.nextInt(100);
        Arrays.sort(testArray);

        for (int numbers : testArray){
            System.out.print(numbers + " ");
        }


        BinarySearch binSearch = new BinarySearch();
        System.out.println();
        System.out.print("Enter number:");
        int key = scanner.nextInt();
        int res = binSearch.search(testArray, key);
        System.out.println("res = " + res);


    }

    static int findUniqueElement(int[] integers) {
        // Since we are warned the array may be very large, we should avoid counting values any more than we need to.

        // We only need the first 3 integers to determine whether we are chasing odds or evens.
        // So, take the first 3 integers and compute the value of Math.abs(i) % 2 on each of them.
        // It will be 0 for even numbers and 1 for odd numbers.
        // Now, add them. If sum is 0 or 1, then we are chasing odds. If sum is 2 or 3, then we are chasing evens.
        int sum = Arrays.stream(integers).limit(3).map(i -> Math.abs(i) % 2).sum();
        int mod = (sum == 0 || sum == 1) ? 1 : 0;

        return Arrays.stream(integers).parallel() // call parallel to get as much bang for the buck on a "large" array
                .filter(n -> Math.abs(n) % 2 == mod).findFirst().getAsInt();
    }
}
