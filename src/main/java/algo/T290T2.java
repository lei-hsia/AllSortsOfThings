package algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lei
 * @date 04/24/2022 10:55 AM
 */
public class T290T2 {
    public static Set<Integer> countLatticePoints(int[][] circles) {
        // make the square based on each circle, minus 4 would be points.
        // store in set: new circle coming: judge if exist in set
        Set<Integer> s = new HashSet();

        for (int[] c : circles) {
            int x1 = c[0] - c[2] , x2 = c[0] + c[2];
            int y1 = c[1] - c[2] , y2 = c[1] + c[2];
            int x0 = c[0], y0 = c[1];

            for (int i = x1; i <= x2; ++i) {
                for (int j = y1; j <= y2; ++j) {
                    if ((i - x0) * (i - x0) + (j - y0) * (j - y0) <= c[2] * c[2]) {
                        s.add(i * 100 + j);
                    }
                }
            }

//            int left = (c[0] - c[2]) * 100 + c[1];
//            int right = (c[0] + c[2]) * 100 + c[1];
//            int up = c[0] * 100 + c[1] - c[2];
//            int down = c[0] * 100 + c[1] + c[2];
//
//            s.add(left);
//            s.add(right);
//            s.add(up);
//            s.add(down);
        }

        return s;
    }


    //[[8,9,6],[9,8,4],[4,1,1],[8,5,1],[7,1,1],[6,7,5],[7,1,1],[7,1,1],[5,5,3]]

    public static void main(String[] args) {
        int[][] c = new int[9][3];
        c[0] = new int[]{8,9,6}; c[1] = new int[]{9,8,4}; c[2] = new int[]{4,1,1};
        c[3] = new int[]{8,5,1}; c[4] = new int[]{7,1,1}; c[5] = new int[]{6,7,5};
        c[6] = new int[]{7,1,1}; c[7] = new int[]{7,1,1}; c[8] = new int[]{5,5,3};
        Set<Integer> s = countLatticePoints(c);
        System.out.println(s.size());

        List<Integer> l = new ArrayList<>(s);
        for (int i = 0; i < l.size(); i++) {
            System.out.print(l.get(i) + ", ");
        }
    }
}