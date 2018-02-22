package com.sturc;

public class BinarySearch {



    public int search (int [] array, int key) {
        int L = 0, M, R = array.length - 1;

        while (L <= R){
            M = L + (R - L)/2;
            if (key < array[M]) R = M - 1;
            else if (key > array[M]) L = M + 1;
            else return M;
        }
    return -1;
    }
}
