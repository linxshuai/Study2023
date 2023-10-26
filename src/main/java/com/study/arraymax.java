package com.study;

public class arraymax {
    public static void main(String[] args) {
        int [] arr={10,20,80,100,-90,70};
        int  n=arr[0];
        for (int i=0;i< arr.length;i++){
            if (n<arr[i]){
                n=arr[i];
            }
        }
        System.out.println("数据最大值是"+n);
    }
}
