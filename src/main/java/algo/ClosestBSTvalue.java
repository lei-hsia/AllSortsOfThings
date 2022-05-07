package algo;

import java.util.*;

/**
 * @author lei
 * @date 04/26/2022 4:54 PM
 */
public class ClosestBSTvalue {
    public static List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> (int) (b[0] - a[0]));
        inorder(root, target, pq, k);

//        while (!pq.isEmpty()) {
//            System.out.println(Arrays.toString(pq.poll()));
//        }

        while (!pq.isEmpty()) {
            res.add((int) pq.poll()[1]);
        }
        return res;
    }

    private static void inorder(TreeNode root, double target, PriorityQueue<double[]> pq, int k) {
        if (root == null) return;
        inorder(root.left, target, pq, k);
        pq.offer(new double[]{Math.abs(root.val - target), root.val});
        if (pq.size() > k) pq.poll();
        inorder(root.right, target, pq, k);
    }


    /*
    *           4
    *       2      5
    *    1    3
    * */
    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(4);TreeNode n2 = new TreeNode(2);TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3); TreeNode n5 = new TreeNode(5);
        n4.left = n2; n4.right = n5; n2.left = n1; n2.right = n3;
        System.out.println(closestKValues(n4, 3.714286, 2));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}