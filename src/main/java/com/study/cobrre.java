package com.study;

public class cobrre {
    public static void main(String[] args) {
        for (int i=0;i<4;i++){
            System.out.println(i);
            if (i==2){
                //continue;//跳过i==2
                //break;//跳出循环，结束循环
                return;//跳出main方法
            }
            System.out.println("running");
        }
        System.out.println("end");
    }
}
