package ap.princeton;

/**
 * @author lei
 * @date 03/12/2022 6:15 PM
 */
public class StringDemo {
    public static void main(String[] args) {
        String animal1 = "elephant";
        String animal2 = "lion";
        swap(animal1, animal2);
        String s = animal1.toUpperCase();
        System.out.println(s);
        animal2.toLowerCase();
        System.out.println(animal1 + " " + animal2);
    }

    public static void swap(String a1, String a2) { String hold = a1;
        a1 = a2;
        a2 = hold;
    }
}
