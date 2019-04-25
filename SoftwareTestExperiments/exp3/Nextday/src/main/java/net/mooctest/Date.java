package main.java.net.mooctest;

public class Date {
    private Day d;
    private Month m;
    private Year y;

    public Date(int pMonth, int pDay, int pYear) {
        y = new Year(pYear);
        m = new Month(pMonth, y);
        d = new Day(pDay, m);
    }

    public void increment() {
        //如果天数自增未非法
        if (!d.increment()) {
            //且月自增未非法
            if (!m.increment()) {
                //将年份自增，并将月份置1
                y.increment();
                m.setMonth(1, y);
            }
            //将天数置1
            d.setDay(1, m);
        }
    }

    public void printDate() {
        System.out.println(m.getMonth() + "/" + d.getDay() + "/" + y.getYear());
    }

    public Day getDay() {
        return d;
    }

    public Month getMonth() {
        return m;
    }

    public Year getYear() {
        return y;
    }

    public boolean equals(Object o) {
        if (o instanceof Date) {
            if (this.y.equals(((Date) o).y) && this.m.equals(((Date) o).m)
                    && this.d.equals(((Date) o).d))
                return true;
        }
        return false;
    }

    public String toString() {
        return (m.getMonth() + "/" + d.getDay() + "/" + y.getYear());
    }
}