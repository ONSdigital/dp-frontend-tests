package Util;

import org.joda.time.DateTime;

/**
 * Created by admin on 31/01/2017.
 */
public class ScheduledTime {

    public static String differentTime(int extraMins) {
        DateTime dt = new DateTime();  // current time
        int month = dt.getMonthOfYear();     // gets the current month
        int hours = dt.getHourOfDay();
        int min = dt.getMinuteOfHour();
        int scheduledMins = min + extraMins;

        return Integer.toString(scheduledMins * 60000);

    }

    public static String currentHour() {
        DateTime dt = new DateTime();  // current time
        int month = dt.getMonthOfYear();     // gets the current month
        int hours = dt.getHourOfDay();
        //  return hours;
        return Integer.toString(hours);
    }

    public static String currentMinute() {
        DateTime dt = new DateTime();  // current time
        int min = dt.getMinuteOfHour();
        return Integer.toString(min);
    }
}
