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
        String message = TimeMessager.getLocalMessage();
        System.out.println(message);
        log.info("Printed on console:" + message);
        log.info("Close application");
    }

}
