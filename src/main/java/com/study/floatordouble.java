package com.study;

public class floatordouble {
    public static void main(String[] args) {
        double n1 =3.1415926;
        float n2 =3.1415926f;
        System.out.println(n1+"\n"+n2);
        double num1 =2.7;
        double num2 =8.1/3;
        System.out.println(num1==num2);
        System.out.println(num1);
        System.out.println(num2);
        if (Math.abs(num1-num2)<0.0000001)
            System.out.println("二者相等");
        else
            System.out.println("二者不相等");
    }
}
