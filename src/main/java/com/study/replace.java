package com.study;

public class replace {
    public static String removeLeadingZeros(String str) {
        // 如果字符串以0开头，去掉0
        if (str.startsWith("0") && str.length() > 1) {
            str = str.substring(1);
            // 递归检查剩余的字符串
            str = removeLeadingZeros(str);
        }
        return str;
    }

    public static String removeEmailSuffix(String email) {
        int index = email.indexOf("@");
        if (index != -1) {
            email = email.substring(0, index);
        }
        return email;
    }

    public static void main(String[] args) {
        String email = "006007@nesc.cn";
        email = removeEmailSuffix(removeLeadingZeros(email));
        System.out.println(email);
    }
}