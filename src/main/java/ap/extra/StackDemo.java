package ap.extra;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author lei
 * @date 03/26/2022 6:32 PM
 */
public class StackDemo {

    /*
    *       ()()(()))())()
    * */
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1); st.push(2); st.push(3);
        Integer peek = st.peek();
        System.out.println(peek);
        Integer pop = st.pop();
        System.out.println(pop);
        Integer peek1 = st.peek();
        System.out.println(peek1);
        System.out.println(st.empty());
        st.pop(); st.pop();
        System.out.println(st.empty());
    }
}
