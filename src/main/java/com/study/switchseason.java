package com.study;

import java.util.Scanner;

public class switchseason {
    public static void main(String[] args) {
        System.out.println("请输入月份信息");
        Scanner scanner = new Scanner(System.in);
        int i =scanner.nextInt();
        switch (i){
            case 3:
            case 4:
            case 5:
                System.out.println("春节");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋季");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println("冬季");
                break;
            default:
                System.out.println("输入信息有误");
        }

    }
}
