package ap.chapter3.questions;

/**
 * @author lei
 * @date 12/18/2021 3:30 PM
 */
public class Tester {
    public void someMethod(int a, int b) {
        int temp = a;
        a  = b;
        b = temp;
    }
}

class TesterMain {
    public static void main(String[] args) {
        int x = 6, y = 8;
        Tester tester = new Tester();
        tester.someMethod(x, y);
    }
}
