package main.java.net.mooctest;

public class Month extends CalendarUnit {
    private Year y;
    private int[] sizeIndex = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public Month(int pMonth, Year y) {
        setMonth(pMonth, y);
    }

    public void setMonth(int pMonth, Year y) {
        setCurrentPos(pMonth);
        //为其添加一个所属年
        this.y = y;
        //判断是否符合规范
        if (!this.isValid()) {
            throw new IllegalArgumentException("Not a valid month");
        }
    }

    public int getMonth() {
        return currentPos;
    }

    //获取月份天数
    public int getMonthSize() {
        if (y.isLeap())
            sizeIndex[1] = 29;
        else
            sizeIndex[1] = 28;
        return sizeIndex[currentPos - 1];
    }

    public boolean increment() {
        currentPos += 1;
        //如果自增后超过12，返回假
        if (currentPos > 12)
            return false;
        else
            return true;
    }

    public boolean isValid() {
        //年份不为空并且不为0
        if (y != null && y.isValid())
            //传入的月份数值符合常识
            if (this.currentPos >= 1 && this.currentPos <= 12)
                return true;
        return false;

    }

    public boolean equals(Object o) {
        if (o instanceof Month) {
            if (this.currentPos == ((Month) o).currentPos
                    && this.y.equals(((Month) o).y))
                return true;
        }
        return false;
    }
}