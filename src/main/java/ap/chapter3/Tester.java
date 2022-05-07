package ap.chapter3;

/**
 * @author lei
 * @date 12/11/2021 4:27 PM
 */
public class Tester {
    public void someMethod(int a, int b){
        int temp = a;
        a = b;
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
