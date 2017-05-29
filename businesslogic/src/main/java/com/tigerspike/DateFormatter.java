package com.tigerspike;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatter {

    private static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    public long formatDate(String publishedDate) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_PATTERN, Locale.getDefault());
        long dateInMillis = 0;
        try {
            Date date = format.parse(publishedDate);
            dateInMillis = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return dateInMillis;
        }
        return dateInMillis;
    }
}



