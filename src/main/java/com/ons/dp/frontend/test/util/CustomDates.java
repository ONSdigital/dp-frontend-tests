package com.ons.dp.frontend.test.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by admin on 14/12/2016.
 */
public class CustomDates {

    public static String getTomorrowsDate() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date()); // Now use today date.
        c.add(Calendar.DATE, 1); // Adding 1 day
        return sdf.format(c.getTime());

    }
}
