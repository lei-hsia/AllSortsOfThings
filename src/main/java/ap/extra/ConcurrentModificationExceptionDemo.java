package ap.extra;

/**
 * @author lei
 * @date 04/23/2022 7:24 PM
 */
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ArrayList;

// Java program to show
// ConcurrentModificationException
public class ConcurrentModificationExceptionDemo {
    // wiki: fast fail
    public static void main(String args[]) {

        // Creating an object of ArrayList Object
        ArrayList<String> arr = new ArrayList<>();

        arr.add("One"); arr.add("Two"); arr.add("Three"); arr.add("Four");

        try {
            // Printing the elements
            System.out.println("ArrayList: ");
            Iterator<String> iter = arr.iterator();

            while (iter.hasNext()) {
                System.out.print(iter.next() + ", ");

                // ConcurrentModificationException
                // is raised here as an element
                // is added during the iteration
                System.out.println("Trying to add between iteration\n");
                arr.add("Five");
            }
        }
        catch (ConcurrentModificationException e) {
            System.out.println(e);
        }

    }
}
