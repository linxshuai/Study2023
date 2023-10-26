package com.study;

public class Stringconvert {
    public static void main(String[] args) {
        int a =10;
        double b =10.0;
        float c =10.0f;
        String s1 = a+"";
        String s2 = b+"";
        String s3 = c+"";
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        String d ="123";
        int i1 = Integer.parseInt(d);
        double i2 = Double.parseDouble(d);
        float i3 = Float.parseFloat(d);
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(d.charAt(0));
        System.out.println(d.charAt(1));
        System.out.println(d.charAt(2));

    }
}
