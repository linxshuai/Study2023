package com.study;

import java.util.Scanner;

public class waternum {
    public static void main(String[] args) {
        //153=1*1*1+5*5*5+3*3*3
       /* Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();*/
        for (int n=0;n<10000;n++){
            int i=n/100;
            int j=n%100/10;
            int k=n%10;
            if (i*i*i+j*j*j+k*k*k==n)
                System.out.println(n+"是水仙花数");

        }

    }
}
