package com.study;

public class forceconvert {
    public static void main(String[] args) {
        // char int  long float double
        // byte short int log float double
        int a =(int)1.9;
        byte b =(byte) 2000;
        System.out.println(a);//精度丢失
        System.out.println(b);//数据溢出
    }
}
