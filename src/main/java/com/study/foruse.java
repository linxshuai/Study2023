package com.study;

public class foruse {
    public static void main(String[] args) {
        int i=0;
        for (;i<10;i++) {
            System.out.println("i="+i);
        }
        int j=0;
        for (;j<10;){
            j++;
            System.out.println("j="+j);
        }
        //1-100取出9的倍数并求和
        int n=0;
        for(int m=1;m<100;m++){
            if(m%9==0){
                n+=m;
                System.out.println(m);
            }

        }
        System.out.println(n);
    }
}
