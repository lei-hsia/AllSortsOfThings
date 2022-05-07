package ap.chapter3.questions;

/**
 * @author lei
 * @date 11/06/2021 11:21 AM
 */
public class IntObject {
    private int num;

    public IntObject() { num = 0; }

    public IntObject(int n) { num = n; }

    public void increment() {
        num++;
    }
}

class IntObjectTest {

    public static IntObject someMethod(IntObject obj) {
        IntObject ans = obj;
        ans.increment();
        return ans;
    }

    public static void main(String[] args) {
        IntObject x = new IntObject(2);
        IntObject y = new IntObject(7);
        IntObject a = y;
        x = someMethod(y);
        y = someMethod(x);
    }
}
