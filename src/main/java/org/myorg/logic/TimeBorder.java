package org.myorg.logic;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Evgeniy.
 */
public class TimeBorder {

    private  static SimpleDateFormat SDF = new SimpleDateFormat("HH:mm:ss.S");


    public static Border getMessage(final Date date) throws ParseException {
        Date current = SDF.parse(SDF.format(date));
        Date morning  = SDF.parse(Border.MORNING.toString());
        Date day  = SDF.parse(Border.DAY.toString());
        Date evening = SDF.parse(Border.EVENING.toString());
        Date night = SDF.parse(Border.NIGHT.toString());

        Border result;

        if(current.getTime() >= morning.getTime() && current.getTime() < day.getTime()){
            result = Border.MORNING;
        }
        else if (current.getTime() >= day.getTime() && current.getTime() < evening.getTime()){
            result = Border.DAY;
        }
        else if (current.getTime() >= day.getTime() && current.getTime() < night.getTime()){
            result = Border.EVENING;
        }
        else {
            result = Border.NIGHT;
        }
        return result;
    }

    public enum Border {
        MORNING("06:00:00.000"),
        DAY("09:00:00.000"),
        EVENING("19:00:00.000"),
        NIGHT("23:00:00.000");

        private final String time;


        Border(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return time;
        }
    }

}
