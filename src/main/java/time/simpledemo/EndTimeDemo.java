package time.simpledemo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lei
 * @date 07/01/2021 5:32 PM
 */
public class EndTimeDemo {
    public static void main(String[] args) {
        // 10位的秒级别的时间戳
        long time1 = 1897767665;
        String result1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(time1 * 1000));
        System.out.println("10位数的时间戳（秒）--->Date:" + result1);

        System.out.println("*******************");
        // pattern: 可以插入各种string，yyyy/MM/dd HH/mm/ss是wildcard
        String result3 = new SimpleDateFormat("yyyy/MM/dd/ HH:mm 到期").format(new Date(time1 * 1000));
        System.out.println("10位数的时间戳（秒）--->Date:" + result3);

        System.out.println("*******************");
        Date date1 = new Date(time1*1000);   //对应的就是时间戳对应的Date
        // 13位的秒级别的时间戳
        double time2 = 1945730332000d;
        String result2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time2);
        System.out.println("13位数的时间戳（毫秒）--->Date:" + result2);
    }
}
