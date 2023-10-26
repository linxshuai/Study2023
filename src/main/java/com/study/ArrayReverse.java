package com.study;

public class ArrayReverse {
    public static void main(String[] args) {
        int [] arr={100,20,15,37,6};
        int [] arr2 = new int[arr.length];
        for (int i=0; i< arr.length; i++ ){
            int temp = arr.length-i-1;
            arr2[i] = arr[temp];
            System.out.println(arr2[i]);

        }
    }
}
