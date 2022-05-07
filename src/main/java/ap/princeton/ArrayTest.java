package ap.princeton;

/**
 * @author lei
 * @date 03/12/2022 6:53 PM
 */
public class ArrayTest {
    public static void main(String[] args) {
        int[] arr3 = {1, 2, 3, 4, 5, 6};

//        for (int e : arr3) {
//            e *= 2;
//            System.out.print(e + " ");
//        }

        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = arr3[i] * 2;
        }
        System.out.println(" ");

        for (int element : arr3)
            System.out.print(element + " ");
    }
}
