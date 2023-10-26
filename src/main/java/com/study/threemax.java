package com.study;

public class threemax {
    public static void main(String[] args) {
        int a =10;
        int b =20;
        int c =30;
        int max =a>b ? a:b;
        int MAX =max >c ?max :c;
        System.out.println(MAX);
        int ttt =(a>b ? a:b) > c ? (a>b ? a:b) : c;
        System.out.println(ttt);
    }
}
