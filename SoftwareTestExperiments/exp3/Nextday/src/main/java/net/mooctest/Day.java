package main.java.net.mooctest;

public class Day extends CalendarUnit {
    private Month m;

    //初始化
    public Day(int pDay, Month m) {
        setDay(pDay, m);
    }

    public boolean increment() {
        currentPos += 1;
        if (currentPos <= m.getMonthSize())
            return true;
        //如果自增后天数超过限定范围，则返回假
        else
            return false;
    }

    public void setDay(int pDay, Month m) {
        setCurrentPos(pDay);
        //为当前天设定一个所属月
        this.m = m;
        if (!this.isValid()) {
            throw new IllegalArgumentException("Not a valid day");
        }
    }

    public int getDay() {
        return currentPos;
    }

    public boolean isValid() {
        //如果月份值非空并有效
        if (m != null && m.isValid())
            //如果天数在有效范围内
            if (this.currentPos >= 1 && this.currentPos <= m.getMonthSize())
                return true;
        return false;

    }

    public boolean equals(Object o) {
        if (o instanceof Day) {
            if (this.currentPos == ((Day) o).currentPos
                    && this.m.equals(((Day) o).m))
                return true;
        }
        return false;
    }
}
