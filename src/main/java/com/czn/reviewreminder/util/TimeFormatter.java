package com.czn.reviewreminder.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeFormatter {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    public static String formatTime(LocalDateTime time) {
        return time.format(formatter);
    }
}
