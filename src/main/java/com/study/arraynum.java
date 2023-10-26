package com.study;

public class arraynum {
    public static void main(String[] args) {
        String [] arr1={"A","B","C"};
        String [] arr2=arr1;
        System.out.println(arr1[0]+"\t"+arr1[1]+"\t"+arr1[2]);
        System.out.println(arr2[0]+"\t"+arr2[1]+"\t"+arr2[2]);
        arr2[0]="YYY";
        System.out.println(arr1[0]+"\t"+arr1[1]+"\t"+arr1[2]);
        System.out.println(arr2[0]+"\t"+arr2[1]+"\t"+arr2[2]);
        int m=100;
        int n=m;
        n=200;
        System.out.println(m+"\t"+n);

    }
}
