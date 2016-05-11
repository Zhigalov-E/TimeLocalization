package org.myorg.logic;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Evgeniy.
 */
public class TimeBorder {

    private static final Logger logger = Logger.getLogger(TimeBorder.class);
    private  static SimpleDateFormat SDF = new SimpleDateFormat("HH:mm:ss.S");


    public static Border getMessage(final Date date) throws ParseException {
        Date current = SDF.parse(SDF.format(date));
        Date morning  = SDF.parse(Border.MORNING.toString());
        Date day  = SDF.parse(Border.DAY.toString());
        Date evening = SDF.parse(Border.EVENING.toString());
        Date night = SDF.parse(Border.NIGHT.toString());

        Border result;

        if(current.getTime() >= morning.getTime() && current.getTime() < day.getTime()){
            logger.info("morning time");
            result = Border.MORNING;
        }
        else if (current.getTime() >= day.getTime() && current.getTime() < evening.getTime()){
            logger.info("day time");
            result = Border.DAY;
        }
        else if (current.getTime() >= day.getTime() && current.getTime() < night.getTime()){
            logger.info("evening time");
            result = Border.EVENING;
        }
        else {
            logger.info("night time");
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
