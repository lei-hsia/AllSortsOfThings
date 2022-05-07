package javabasic;

import java.math.BigDecimal;

/**
 * @author lei
 * @date 11/23/2021 3:30 PM
 */
public class BigDecimalDemo {
    public static void main(String[] args) {
        double i = 0.193;
        BigDecimal bigDecimal = BigDecimal.valueOf(i).setScale(6, BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimal);
    }
}
