package com.mattoffe.Eccomerce.utils;

public class TicketGenerator {
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    public static String getRandomTicket() {
        return getRandomNumber(1000, 10000) + "-"
                + getRandomNumber(1000, 10000) + "-" +
                getRandomNumber(1000, 10000) + "-" +
                getRandomNumber(1000, 10000);
    }
}
