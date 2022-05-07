package javabasic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lei
 * @date 10/23/2021 6:09 PM
 */
public class SwapValueDemo {
    public static void main(String[] args) {
        int i = 5;
        while (i >= 0) {
            System.out.println(i);
            --i;
        }

        List<Integer> collection = new ArrayList<>();
        collection.add(1); collection.add(2); collection.add(5);
        for (int e : collection) {
            System.out.println(e);
        }
    }
}
