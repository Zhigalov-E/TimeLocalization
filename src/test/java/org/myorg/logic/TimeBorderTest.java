package org.myorg.logic;


import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Unit test for simple TimeBorderTest.
 */
public class TimeBorderTest {
    private  static SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.S");

    @Test
    public  void testGetMorningBorder() throws ParseException {
        checkTimePeriod("06:00:00.000", TimeBorder.Border.MORNING);
    }


    @Test
    public  void testGetMorningBorder2() throws ParseException {
        checkTimePeriod("08:59:59.999", TimeBorder.Border.MORNING);
    }

    @Test
    public  void testGetDayBorder() throws ParseException {
        checkTimePeriod("09:00:00.000", TimeBorder.Border.DAY);
    }


    @Test
    public  void testGetNotDayBorder() throws ParseException {
        checkTimePeriod("18:59:59.999", TimeBorder.Border.DAY);
    }

    @Test
    public  void testGetEveningBorder() throws ParseException {
        checkTimePeriod("19:00:00.000", TimeBorder.Border.EVENING);
    }


    @Test
    public  void testGetEveningBorder2() throws ParseException {
        checkTimePeriod("22:59:59.999", TimeBorder.Border.EVENING);
    }

    @Test
    public  void testGetNightBorder() throws ParseException {
        checkTimePeriod("23:00:00.000", TimeBorder.Border.NIGHT);

    }


    @Test
    public  void testGetNightBorder2() throws ParseException {
        checkTimePeriod("05:59:59.999", TimeBorder.Border.NIGHT);
    }

    private static void checkTimePeriod(String time, TimeBorder.Border timeBorderExpected) throws ParseException {
        Date date = dateFormat.parse(time);
        TimeBorder.Border timeBorder = TimeBorder.getBorder(date);
        Assert.assertEquals(timeBorder, timeBorderExpected);
    }

}
