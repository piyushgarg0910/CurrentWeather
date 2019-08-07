package com.gargpiyush.android.currentweather.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Piyush Garg
 * on 8/6/2019
 * at 20:23.
 */
public class ConvertUnixTimeToDateTime {

    public static String[] covert(int unixTime, String timeZone){

        Date date = new java.util.Date(unixTime*1000L);

        String [] s = new String[3];

        SimpleDateFormat sdf1 = new java.text
                .SimpleDateFormat("EEE",Locale.US);
        sdf1.setTimeZone(java.util.TimeZone.getTimeZone(getZone(timeZone)));
        s[0] = sdf1.format(date);

        SimpleDateFormat sdf2 = new java.text
                .SimpleDateFormat("MM/dd",Locale.US);
        sdf2.setTimeZone(java.util.TimeZone.getTimeZone(getZone(timeZone)));
        s[1] = sdf2.format(date);

        SimpleDateFormat sdf3 = new java.text
                .SimpleDateFormat("HH:mm",Locale.US);
        sdf3.setTimeZone(java.util.TimeZone.getTimeZone(getZone(timeZone)));
        s[2] = sdf3.format(date);

        return s;
    }

    private static String getZone(String zone){
        switch (zone){
            case "America/New_York":
                return "GMT-4";

            case "America/Indiana/Indianapolis":
                return "GMY-4";

            case "America/Detroit":
                return "GMT-5";

            case "America/Denver":
                return "GMT-6";

            case "America/Los_Angeles":
                return "GMT-7";

            case "America/Anchorage":
                return "GMT-9";

            case "Pacific/Honolulu":
                return "GMT-10";

            default:
                return "GMT-4";
        }
    }
}