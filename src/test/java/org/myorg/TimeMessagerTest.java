package org.myorg;

import org.junit.Assert;
import org.junit.Test;
import org.myorg.logic.TimeBorder;
import org.myorg.logic.TimeMessager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Evgeniy
 */
public class TimeMessagerTest {

    private  static SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.S");

    @Test
    public  void testGetRuMessage() throws ParseException {
        Locale locale = new Locale("ru");
        Date date = dateFormat.parse("06:00:00.000");
        TimeMessager timeMessager = new TimeMessager(date, locale);
        Assert.assertEquals(timeMessager.getLocalMessage(), "Доброе утро, Мир!");
    }

    @Test
    public  void testGetEnMessage() throws ParseException {
        Locale locale = new Locale("en");
        Date date = dateFormat.parse("06:00:00.000");
        TimeMessager timeMessager = new TimeMessager(date, locale);
        Assert.assertEquals(timeMessager.getLocalMessage(), "Good morning, World!");
    }

}
