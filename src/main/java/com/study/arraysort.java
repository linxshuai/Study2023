package com.study;

public class arraysort {
    public static void main(String[] args) {
        int [] arr={10,30,100,20,4};
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 1; j < arr.length ; j++) {
                int tmp=arr[j-1];
                if (arr[j]<arr[j-1]){
                    arr[j-1]=arr[j];
                    arr[j] =tmp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}

