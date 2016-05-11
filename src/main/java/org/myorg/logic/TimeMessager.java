package org.myorg.logic;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Evgeniy
 */
public class TimeMessager {

    private static String RESOURCE = "message";


    private TimeBorder.Border dayPart;
    private Locale locale;


    public TimeMessager(Date date) throws ParseException {
        this.dayPart = TimeBorder.getMessage(date);
        this.locale = Locale.getDefault();
    }

    public TimeMessager(Date date, Locale locale) throws ParseException {
        this.dayPart = TimeBorder.getMessage(date);
        this.locale = locale;
    }

    public String getLocalMessage() {
        ResourceBundle bundle = ResourceBundle.getBundle(RESOURCE, locale);
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

    public TimeBorder.Border getDayPart() {
        return dayPart;
    }

    public void setDayPart(TimeBorder.Border dayPart) {
        this.dayPart = dayPart;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
