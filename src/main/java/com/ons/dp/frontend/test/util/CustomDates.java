package com.ons.dp.frontend.test.util;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class CustomDates {

	public static String getDate(int beforeAfterToday) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, beforeAfterToday);
		return sdf.format(c.getTime());

    }

    public static String getDateInDiffFormat(int beforeAfterToday) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM YYY");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date()); // Now use today date.
        c.add(Calendar.DATE, beforeAfterToday);
        return sdf.format(c.getTime());

    }

    // To get the Date Format in "Monday 06 February 2017"
    public static String getFullDateWithDay(int beforeAfterToday) {

        Format formatter = new SimpleDateFormat("EEEE dd MMMM yyyy");
        String today = formatter.format(new Date());
        return today;

    }




}
