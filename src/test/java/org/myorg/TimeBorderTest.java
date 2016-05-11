package org.myorg;


import org.junit.Assert;
import org.junit.Test;
import org.myorg.logic.TimeBorder;

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
        Date date = dateFormat.parse("06:00:00.000");
        TimeBorder.Border timeBorder = TimeBorder.getMessage(date);
        Assert.assertEquals(timeBorder, TimeBorder.Border.MORNING);
    }


    @Test
    public  void testGetMorningBorder2() throws ParseException {
        Date date = dateFormat.parse("08:59:59.999");
        TimeBorder.Border timeBorder = TimeBorder.getMessage(date);
        Assert.assertEquals(timeBorder, TimeBorder.Border.MORNING);
    }

    @Test
    public  void testGetDayBorder() throws ParseException {
        Date date = dateFormat.parse("09:00:00.000");
        TimeBorder.Border timeBorder = TimeBorder.getMessage(date);
        Assert.assertEquals(timeBorder, TimeBorder.Border.DAY);
    }


    @Test
    public  void testGetNotDayBorder() throws ParseException {
        Date date = dateFormat.parse("18:59:59.999");
        TimeBorder.Border timeBorder = TimeBorder.getMessage(date);
        Assert.assertEquals(timeBorder, TimeBorder.Border.DAY);
    }

    @Test
    public  void testGetEveningBorder() throws ParseException {
        Date date = dateFormat.parse("19:00:00.000");
        TimeBorder.Border timeBorder = TimeBorder.getMessage(date);
        Assert.assertEquals(timeBorder, TimeBorder.Border.EVENING);
    }


    @Test
    public  void testGetEveningBorder2() throws ParseException {
        Date date = dateFormat.parse("22:59:59.999");
        TimeBorder.Border timeBorder = TimeBorder.getMessage(date);
        Assert.assertEquals(timeBorder, TimeBorder.Border.EVENING);
    }

    @Test
    public  void testGetNightBorder() throws ParseException {
        Date date = dateFormat.parse("23:00:00.000");
        TimeBorder.Border timeBorder = TimeBorder.getMessage(date);
        Assert.assertEquals(timeBorder, TimeBorder.Border.NIGHT);
    }


    @Test
    public  void testGetNightBorder2() throws ParseException {
        Date date = dateFormat.parse("05:59:59.999");
        TimeBorder.Border timeBorder = TimeBorder.getMessage(date);
        Assert.assertEquals(timeBorder, TimeBorder.Border.NIGHT);
    }

}
