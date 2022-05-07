package ap.chapter2;

/**
 * @author lei
 * @date 12/11/2021 6:16 PM
 */
public class Q21 {
    public static void main(String[] args) {
        for (int i = 0; i <= 6 ; i++) {
            for (int k = 1; k <=6 ; k++)
                if (k == i)
                    System.out.println(2 * k);
                else
                    System.out.println("-");
            System.out.println();
        }
    }
}
