package com.study;

import java.util.Scanner;

public class switchsorce {
    public static void main(String[] args) {
        System.out.println("请输入您的成绩");
        Scanner scanner = new Scanner(System.in);
        double v =scanner.nextDouble();
        //v >60 v/60 1;v<60 v/60=0
        if (v>=0&&v<=100){
            switch ((int)v/60){
                case 0:{
                    System.out.println("成绩不合格");
                }
                break;
                case 1:{
                    System.out.println("成绩合格");
                }
                break;
            }

        }else {
            System.out.println("输入信息有误");
        }


    }
}
