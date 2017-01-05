package com.ons.dp.frontend.test.util;

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

}
