package time.simpledemo;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lei
 * @date 06/29/2021 4:11 PM
 */
public class DateFormatFailedDemo {
    public static void main(String[] args) {
        Timestamp stamp = new Timestamp(System.currentTimeMillis());
         System.out.println(System.currentTimeMillis());

        long timeDiff = (1624955910339L - System.currentTimeMillis())/(1000*60*60);

        Date date = new Date(stamp.getTime());
        System.out.println(date); // Tue Jun 29 16:14:08 CST 2021


        if (timeDiff > 4L) {
//            DateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
//            System.out.println(">4L: " + simpleDateFormat.format(date));
        } else {
            DateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
            System.out.println(simpleDateFormat.format(date));
            DateFormat hour = new SimpleDateFormat("HH");
            DateFormat min = new SimpleDateFormat("mm");
            DateFormat sec = new SimpleDateFormat("ss");
            System.out.println(hour.format(date)+"小时"+min.format(date)+"分"+sec.format(date)+"秒内有效");
        }
    }
}
