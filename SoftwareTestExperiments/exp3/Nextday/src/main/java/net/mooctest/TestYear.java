package main.java.net.mooctest;

import static org.junit.Assert.*;
import main.java.net.mooctest.*;
import org.junit.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestYear {
    //测试年类
    @Test
    public void testYear(){
        Year year;
        Year year2 = new Year(-1);
        Year year3 = new Year(1);
        Year year4 = new Year(1996);
        Year year5 = new Year(2000);
        Year year6 = new Year(-1997);
        Year year7 = new Year(-2001);

        //使其isValid 返回假
        try { year = new Year(0); } catch (Exception e) {};
        //传入-1，使其自增
        assertTrue(year2.increment());
        assertEquals(year2.getYear(), 1);
        assertTrue(year4.isLeap());
        assertTrue(year5.isLeap());
        year2.setYear(-1997);
        assertTrue(year6.isLeap());
        year2.setYear(-2001);
        assertTrue(year7.isLeap());
        assertFalse(year4.equals(year5));
        year2.setYear(2000);
        assertTrue(year2.equals(year5));
        year2.setYear(1);
        assertFalse(year2.isLeap());


    }

}
