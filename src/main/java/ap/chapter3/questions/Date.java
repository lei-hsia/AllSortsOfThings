package ap.chapter3.questions;

import java.util.Scanner;

/**
 * @author lei
 * @date 12/18/2021 11:00 AM
 */
public class Date {
    private int day;
    private int month;
    private int year;

    private static int staticMonth;

    public Date(){}

    public Date(int month, int day, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int month() {
        return 0;
    }

    public static int staticGetMonth() {
        return staticMonth;
    }

    public int day() {
        return day;
    }

    public int year() {
        return year;
    }

    @Override
    public String toString() {
        return String.format("%d/%d/%d", month, day, year);
    }

    /*
    *       q8
    * */
    public void write1() {
        System.out.println(month + "/" + day + "/" + year);
    }

    /*  In an instance method: call to other instance method, or static method: ✅
    * */
    public void write2() {
        System.out.println(month() + staticGetMonth());
    }

    public void write3() {
        System.out.println(this);
    }

    /*  In an static method: call to static method: ✅;
                             call instance method: must: object calls it!
     * */
    public static void someStaticMethod(String[] args) {
        int i = staticGetMonth();
        Date date = new Date();
        date.month();
    }


    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

/*     q11 */
    public static void main(String[] args) {
        Date oldDate = new Date(1, 13, 1900);
        Date recentDate = null;
        addCentury(recentDate, oldDate);
    }

    private static void addCentury(Date recent, Date old) {
        old.addYears(100);
        recent = old;
    }

    private void addYears(int n) {
        this.year += n;
    }


}