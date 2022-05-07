package time.simpledemo;

import java.util.Calendar;
import java.util.Date;

/**
 * @author lei
 * @date 06/29/2021 4:40 PM
 */
public class CountdownCalendarDemo {
    public static void main(String[] args) {
//        Calendar calendar = Calendar.getInstance();
//        System.out.println(System.currentTimeMillis());
//        calendar.set(2021, Calendar.JUNE,29,23,0,0);
//        long endTime = calendar.getTimeInMillis();
        long endTime = System.currentTimeMillis();
        Date date = new Date();
        long startTime = date.getTime();
        long secDiff = (endTime - startTime) / 1000;

        while (secDiff > 0) {
            secDiff--;
            long hh = secDiff / 60 / 60 % 60;
            long mm = secDiff / 60 % 60;
            long ss = secDiff % 60;
            System.out.println("还剩" + hh + "小时" + mm + "分钟" + ss + "秒");
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
