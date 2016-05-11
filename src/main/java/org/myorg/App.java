package org.myorg;

import org.apache.log4j.Logger;
import org.myorg.logic.TimeMessager;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;


/**
 * Hello world!
 */
public class App {
    private static final Logger log = Logger.getLogger(App.class);

    public static void main(String[] args) {
        log.info("Start application");


        try {
            TimeMessager tm = new TimeMessager(new Date());
            String message = tm.getLocalMessage();
            System.out.println(message);
            log.info("Printed on console:" + message);
        } catch (ParseException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }

        log.info("Close application");
    }

}
