package ap.princeton;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lei
 * @date 03/12/2022 6:26 PM
 */
public class SwapArrTest {
    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {21, 22, 23, 24, 25};

        swap2(a1, a2);
        List<int[]> ints = swap2(a1, a2);
        a1 = ints.get(0);
        a2 = ints.get(1);

        for (int i : a1) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : a2) {
            System.out.print(i + " ");
        }
    }

    public static List<int[]> swap2(int[] a1, int[] a2) {
        int[] arr = a1;
        a1 = a2;
        a2 = arr;
        List<int[]> arrReference = new ArrayList<>();
        arrReference.add(a1);
        arrReference.add(a2);
        return arrReference;
    }
}
