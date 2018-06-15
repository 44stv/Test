package com.sturc;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder();

        for (String string : args) {
            builder.append(string);
        }
        System.out.println(builder.toString());

/*        int size = 10;
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
        System.out.println("res = " + res);*/

/*        double a, b = 2, c = 2;

        long startTime = System.nanoTime();

        a = Math.atan2(b, c);

        long endTime = System.nanoTime();
        System.out.println(endTime-startTime);*/

/*        int[] unsorted = {32, 39, 21, 45, 23, 3, 2};
        System.out.println("Array before sort: " + Arrays.toString(unsorted));
        int[] sorted = bubbleSort(unsorted);*/

        //fibonacciRecursive(5);

/*        for (int i = 1; i <= 5; i++) {
            System.out.print(fibonacciRecursive(i) + " ");
        }*/

/*        System.out.println(fibonacciRecursive(10));
        System.out.println(fibonacciIterative(10));*/
    }


    public static String createString(double fl, int i, String str) {
        return String.format("This is real number %f, integer number %d, string %s",fl, i, str);
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

    private static int sortDesc(final int num) {

        String[] array = String.valueOf(num).split("");
        Arrays.sort(array, Collections.reverseOrder());

        return Integer.valueOf(String.join("", array));

//        return Integer.parseInt(String.valueOf(num)
//                .chars()
//                .mapToObj(i -> String.valueOf(Character.getNumericValue(i)))
//                .sorted(Comparator.reverseOrder())
//                .collect(Collectors.joining()));

    }


    public static int findIt(int[] A) {

        int i, count = 0;
        for (i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (A[i] == A[j]) {
                    count++;
                }
            }
            if (count % 2 == 0) {
                return A[i];
            }
        }
        return -1;

/*        int xor = 0;
        for (int i = 0; i < A.length; i++) {
            xor ^= A[i];
        }
        return xor;*/
    }

    public static int[] minMax(int[] arr) {
        Arrays.sort(arr);
        return new int[]{arr[0], arr[arr.length - 1]};
    }

    public static String convert(String phrase) {

/*        StringBuilder sb = new StringBuilder();

        if (phrase == null || phrase.isEmpty()) {
            return null;
        }

        String[] array = phrase.split(" ");
        for (String word : array) {
            word = Character.toUpperCase(word.charAt(0)) + word.substring(1);
            sb.append(word);
            sb.append(" ");
        }
        return sb.toString().trim();*/

        if (phrase == null || phrase.equals("")) return null;

        char[] array = phrase.toCharArray();

        for (int x = 0; x < array.length; x++) {
            if (x == 0 || array[x - 1] == ' ') {
                array[x] = Character.toUpperCase(array[x]);
            }
        }
        return new String(array);
    }

    public static double findUniqueDouble(double[] array) {
        Arrays.sort(array);

        if (array[0] == array[1]) {
            return array[array.length - 1];
        } else
            return array[0];
    }

    public static int[] bubbleSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
            System.out.println("array after " + (i + 1) + " pass: " + Arrays.toString(array));
        }

        return array;
    }

    public static int fibonacciRecursive(int number) {
        if (number <= 1) {
            return number;
        }

        return fibonacciRecursive(number - 1) + fibonacciRecursive(number - 2);
    }

    public static int fibonacciIterative(int number) {
        if (number <= 1) {
            return number;
        }
        int f1 = 1;
        int f2 = 2;

        for (int i = 2; i < number; i++) {
            int temp = f2;
            f2 += f1;
            f1 = temp;
        }
        return f2;
    }

}