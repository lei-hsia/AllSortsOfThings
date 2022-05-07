package javabasic;

/**
 * @author lei
 * @date 11/26/2021 11:20 AM
 */
public class TwoForLoopInnerContinueDemo {
    public static void main(String[] args) {


        for (int i = 0; i < 5; i++) {
            System.out.println("i " + i);
            for (int j = 0; j < 3; j++) {
                if (j == 1) {
                    break;
                }
                System.out.println("j " + j);
            }
        }

        System.out.println((131072 & 393216) >> 17);
        System.out.println((0 & 393216) >> 17);
    }
}
