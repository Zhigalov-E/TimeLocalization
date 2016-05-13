package org.myorg.logic;

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

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.S");
    private static  final String SOME_TIME =  "06:00:00.000";

    @Test
    public  void testGetRuMessage() throws ParseException {
        checkMessageForLocale("ru", SOME_TIME, "Доброе утро, Мир!");
    }

    @Test
    public  void testGetEnMessage() throws ParseException {
        checkMessageForLocale("en", SOME_TIME, "Good morning, World!");
    }

    private void checkMessageForLocale(String lang, String time, String expectedMessage) throws ParseException {
        Locale locale = new Locale(lang);
        Date date = dateFormat.parse(time);
        Assert.assertEquals(TimeMessager.getLocalMessage(date, locale), expectedMessage);
    }

}
