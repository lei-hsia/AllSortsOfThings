package ap.chapter7;

/**
 * @author lei
 * @date 01/07/2022 3:40 PM
 */
public class ArrayPresentationDemo {
    public static void main(String[] args) {

        int[] numbers = new int[7];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }


        System.out.println(numbers[4]);
    }
}
