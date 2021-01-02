package com.volasoftware.dtomapper.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static int calculateAge(LocalDate birthday) {
        LocalDate currentDate = LocalDate.now();

        if(birthday != null) {
            return Period.between(birthday, currentDate).getYears();
        }

        return 0;
    }

    public static String formatDateTime(LocalDateTime dateTime) {
        return DateTimeFormatter.ofPattern(DATETIME_PATTERN).format(dateTime);
    }
}
