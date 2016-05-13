package org.myorg.logic;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Evgeniy.
 */
public class TimeBorder {

    public static Border getBorder(final Date current) {

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(current);
        int hours = calendar.get(Calendar.HOUR_OF_DAY);

        Border result;
        if(hours >= 6 && hours < 9 ){
            result = Border.MORNING;
        }
        else if (hours >= 9 && hours < 19 ){
            result = Border.DAY;
        }
        else if (hours >= 19 && hours < 23){
            result = Border.EVENING;
        }
        else {
            result = Border.NIGHT;
        }
        return result;
    }

    public enum Border {
        MORNING, DAY, EVENING, NIGHT
    }

}
