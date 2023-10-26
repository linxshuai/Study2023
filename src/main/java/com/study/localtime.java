

package com.study;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class localtime {
    public static void main(String[] args) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(timestamp);


    }
}
