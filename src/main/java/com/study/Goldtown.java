package com.study;


public class Goldtown {
    public static void main(String[] args) {
        //    *       5
        //   ***      4
        //  *****     3
        // *******    2
        //*********   1
        int n=10;
        for (int i=1;i<=n;i++){
            for (int m=n;m>=i;m--){
                System.out.print(" ");
            }
            for (int j=1;j<=2*i-1;j++){
                if (j==1||j==2*i-1){
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
    }
}
