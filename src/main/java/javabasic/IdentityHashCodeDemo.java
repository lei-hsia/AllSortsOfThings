package javabasic;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

/**
 * @author lei
 * @date 08/14/2021 3:32 PM
 */
public class IdentityHashCodeDemo {
    public static void main(String[] args) {
        //String taskName1 = "0814-task25";
        String taskName2 = "0814-task26";
        String taskName3 = "0814-task27";

        //System.out.println((System.identityHashCode(taskName1)+"").getBytes());
        System.out.println(System.identityHashCode(taskName2)+"");
        System.out.println(System.identityHashCode(taskName2)+"");
        System.out.println((System.identityHashCode(taskName2)+"").getBytes());
        System.out.println((System.identityHashCode(taskName2)+"").getBytes());
        System.out.println((System.identityHashCode(taskName3)+"").getBytes());

        System.out.println();
        //System.out.println(Base64.getEncoder().encode(taskName1.getBytes()));
        System.out.println(Base64.getEncoder().encode(taskName2.getBytes()));
        System.out.println(Base64.getEncoder().encode(taskName3.getBytes()));
    }
}
