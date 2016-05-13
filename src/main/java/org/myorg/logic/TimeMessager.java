package org.myorg.logic;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Evgeniy
 */
public class TimeMessager {

    private static final String RESOURCE = "message";
    private static final Locale DEFAULT_LOCALE = Locale.getDefault();

    public static String getLocalMessage(Date date, Locale locale) {
        return getMessageFromBundleResouse(date, locale);
    }
    public static String getLocalMessage(Date date) {
        return getMessageFromBundleResouse(date, DEFAULT_LOCALE);
    }
    public static String getLocalMessage() {
        return getMessageFromBundleResouse(new Date(), DEFAULT_LOCALE);
    }

    private static String getMessageFromBundleResouse(Date date, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle(RESOURCE, locale);
        TimeBorder.Border dayPart = TimeBorder.getBorder(date);
        String message = "";
        switch (dayPart) {
            case MORNING:
                message = bundle.getString("good.morning");
                break;
            case DAY:
                message = bundle.getString("good.day");
                break;
            case EVENING:
                message = bundle.getString("good.evening");
                break;
            case NIGHT:
                message = bundle.getString("good.night");
                break;
        }
        return message;
    }


}
