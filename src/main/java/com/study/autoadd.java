package com.study;

public class autoadd {
    public static void main(String[] args) {
        int i = 1;
        int j;
        int m;
        j = i++;//j=i=1;i++=2
        System.out.println(i);
        m = ++i;//i++=2;++i  =3
        System.out.println(j+"\n"+i+"\n"+m);
        int d =1;
        d = ++d;
        System.out.println(d);
    }
}
