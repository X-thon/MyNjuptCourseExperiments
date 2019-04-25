package test.java.net.mooctest;

import static org.junit.Assert.*;
import main.java.net.mooctest.*;
import org.junit.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class NextdayTest {

    @Rule public ExpectedException thrown = ExpectedException.none();



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


    }


    @Test
    public void test() {
        Nextday n = new Nextday();
        Date date;
        Year years;
        Month months;
        Day days;

        //Year
        //下面是一个isLeap为真的
        Year year = new Year(2000);
        Year year_2 = new Year(2000);

        Year year_3 = new Year(2002);
        Year year_4 = new Year(-1);
        Year year_5 = new Year(-2001);
        Year year_6 = new Year(1996);


        //assertEquals(2001, year.increment());
        //验证isLeap-true
        assertTrue(year.isLeap());
        //验证isLeap-false
        assertFalse(year_3.isLeap());
        //验证isLeap-else if
        assertTrue(year_5.isLeap());
        //验证取值
        assertEquals(2000, year.getYear());
        //验证自增&if
        assertTrue(year_4.increment());
        //验证相等函数-真
        assertTrue(year.equals(year_2));
        //验证相等函数-假
        assertFalse(year.equals(year_3));
        //init
        try { year_5.setYear(0); }catch (Exception e){}


        year.setYear(2019);
        //Month
        Month month = new Month(2, year);
        assertEquals(2, month.getMonth());
        assertEquals(28, month.getMonthSize());
        Month month2 = new Month(2, year_2);
        assertEquals(29, month2.getMonthSize());
        assertTrue(month.increment());
        year_3.setYear(2019);
        Month month3 = new Month(12, year_3);
        assertFalse(month3.increment());
        assertFalse(month.equals(year_3));
        Month month4 = new Month(3, year_3);
        assertTrue(month.equals(month4));
        //init
        try { month.setMonth( 0, new Year(2019)); } catch ( Exception e ) {}
        try { month.setMonth(13, new Year(2019)); } catch ( Exception e ) {}
        try { month.setMonth( 4, new Year(-10)); } catch ( Exception e) {}
        try { month.setMonth( 5, new Year(0));} catch ( Exception e) {}
        //incr
        try { month.setMonth(12, new Year(2020)); month.increment(); } catch ( Exception e){}

        //Day
        Day day = new Day(21, new Month(4, new Year(2019)));
        //incr
        assertTrue(day.increment());
        //get
        assertEquals(22, day.getDay());
        //isValid
        assertTrue(day.isValid());
        Day day2 = new Day(22, new Month(4, new Year(2019)));
        assertTrue(day.equals(day2));
        Day day3 = new Day(30, new Month(4, new Year(2019)));
        assertFalse(day.equals(day3));
        //incr
        try { day3.increment(); } catch (Exception e){}
        //init
        try { day = new Day(21, new Month(13, new Year(2019))); } catch (Exception e){}
        try { day = new Day(22, new Month(10, new Year(0))); } catch (Exception e){}
        try { day = new Day(40, new Month(7, new Year(2019))); } catch (Exception e){}
        try { day = new Day(0, new Month(5, new Year(2019))); } catch (Exception e){}
        try { day = new Day(21, new Month(-1, new Year(2019))); } catch (Exception e){}


        //Date
        int m = 4, d = 21, y = 2019;
        date = new Date(m, d, y);
        assertEquals(date.toString(), m+"/"+d+"/"+y);
        assertTrue(date.equals(date));
        assertFalse(date.equals(new Date(m+1,d,y)));
        assertFalse(date.equals(new Date(m,d+1,y)));
        assertFalse(date.equals(new Date(m, d, y+1)));
        for(int y1=-3021;y1<3021;y1++)
        {
            for(int m1=-2;m1<14;m1++)
            {
                for(int d1=-2;d1<32;d1++)
                {
                    try{
                        date = new Date(m1,d1,y1);
                        date.increment();
                    }
                    catch(Exception e){

                    }
                }
            }
        }
        date = new Date(m, d, y);
        Date dd = n.nextDay(date);
        date.increment();
        assertEquals(date, dd);
    }

}
