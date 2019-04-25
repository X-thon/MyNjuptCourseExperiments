package main.java.net.mooctest;

public class Year extends CalendarUnit {
    //构造函数传入一个整型pYear
    public Year(int pYear) {
        setYear(pYear);
    }

    public void setYear(int pYear) {
        setCurrentPos(pYear);
        //在此处判断数值是否符合规定
        if (!this.isValid()) {
            //如果不符合，则抛出异常
            //
            throw new IllegalArgumentException("Not a valid month");
        }
    }

    //实际上等同于父类方法 getCurrentPos()
    public int getYear() {
        return currentPos;
    }

    //自增操作
    public boolean increment() {
        //先加1，再判断
        currentPos = currentPos + 1;
        //如果负数自增至0，则将其置1
        //
        if (currentPos == 0)
            currentPos = 1;
        return true;
    }

    public boolean isLeap() {
        if (currentPos >= 0
                && (((currentPos % 4 == 0) && (currentPos % 100 != 0)) || (currentPos % 400 == 0)))
            return true;
        else if (currentPos < 0
                && ((((currentPos * -1) % 4 == 1) && ((currentPos * -1) % 100 != 1)) || ((currentPos * -1) % 400 == 1)))
            return true;
        return false;
    }

    //如果当前的currentPos非0即返回真
    //也可以为负数
    protected boolean isValid() {
        if (this.currentPos != 0)
            return true;
        return false;
    }

    public boolean equals(Object o) {
        if (o instanceof Year) {
            if (this.currentPos == ((Year) o).currentPos)
                return true;
        }
        return false;
    }
}