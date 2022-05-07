package algo.c;

/**
 * @author lei
 * @date 04/22/2022 3:09 PM
 */
public class MatrixSummation {
    /*
    *   Given after matrix, give before matrix
    *
    *   hint: 2-directional prefix sum
    * */
    public static int[][] beforeMatrix(int[][] afterMatrix) {
        int m=afterMatrix.length;
        int n=afterMatrix[0].length;

        for(int i=m-1;i>=0;i--) {
            for(int j=n-1;j>=0;j--) {

                int left = j==0 ? 0 : afterMatrix[i][j-1];
                int up = i==0 ? 0 : afterMatrix[i-1][j];
                int corner = i==0 || j==0 ? 0 : afterMatrix[i-1][j-1];

                afterMatrix[i][j]-=left+up-corner;
            }
        }

        return afterMatrix;
    }

    public static void main(String[] args) {
        /*
        *    [2 3]   [2, 5]
        *    [5 7]   [7, 17]
        * */
        int[][] after = {{2, 5}, {7, 17}};
        for (int[] row : beforeMatrix(after)) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
