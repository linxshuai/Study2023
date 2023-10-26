package com.study;

public class logicoperate {
    public static void main(String[] args) {
        boolean b1 =true;
        boolean b2 =true;
        boolean b3 =false;
        boolean b4 =false;
        if (b1&!b3)
            System.out.println("正确");
        int i =20;
        if (i<10 && i++>20){
            System.out.println("yes");
        }
        System.out.println(i);
        int j =20;
        if (j<10 & j++>20){
            System.out.println("yes");
        }
        System.out.println(j);
    }


}
