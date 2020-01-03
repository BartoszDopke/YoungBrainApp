package com.pracainzynierska.inzynierka.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTimeUtils {

    /**
     * @return returns current date as string in "31-01-2018" format
     */

    public static String getDate() {

        // Fetching date and time from the system
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy ", Locale.getDefault()); // getting default locale of the system

        String dateFormat = s.format(new Date(System.currentTimeMillis())); // Formatting
        // Date

        return dateFormat;
    }
}
