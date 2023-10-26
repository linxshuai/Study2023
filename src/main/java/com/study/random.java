package com.study;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
public class random {
    public static void main(String[] args) {
        Random random = new Random();
        StringBuilder rand = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            rand.append(random.nextInt(10));
        }
        String randomNum = rand.toString();
        System.out.println(randomNum);
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(time);
        String time2 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String transactionId= "JFSYS1" + time2 +randomNum;
        System.out.println(transactionId);

    }
}
