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
}
