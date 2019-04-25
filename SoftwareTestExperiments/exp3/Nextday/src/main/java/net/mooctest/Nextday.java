package main.java.net.mooctest;

public class Nextday {

    public static Date nextDay(Date d) {
        //传入一个Date类型的变量 d
        Date dd = new Date(d.getMonth().getCurrentPos(), d.getDay().getCurrentPos(), d.getYear().getCurrentPos());
        dd.increment();
        return dd;
    }

}
