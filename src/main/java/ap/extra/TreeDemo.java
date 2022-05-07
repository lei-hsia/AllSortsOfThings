package ap.extra;

import algo.GraphTraversal;

import java.util.*;

/**
 * @author lei
 * @date 04/16/2022 7:30 PM
 */
public class TreeDemo {
    /*
    *   preorder traversal,
    *   inorder
    *   postorder
    *
    *   iterative
    *   recursive
    *
    *                   4
    *               2          6
    *            1     3     5   7
    *              2.8  3.5
    * */
    private List<TreeNode> DFS(TreeNode root) {
        return inorderIterative(root);
    }

    // [[4], [2, 6], [1, 3, 5, 7]]
    private static List<List<TreeNode>> BFS(TreeNode root) {
        List<List<TreeNode>> res = new ArrayList<>();

        // if using a queue
        // iterative
        Queue<TreeNode> q  = new LinkedList<>();
        q.add(root);
        List<TreeNode> tmp = new ArrayList<>();

        while (!q.isEmpty()) {
            int size = q.size();
            tmp.clear();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                tmp.add(cur);
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            for (TreeNode i : tmp) {
                System.out.print(i.val + " ");
            }
            System.out.println();
            res.add(tmp);
        }

        // recursive
        // bfsHelper(root, res, 0);
        return res;

    }

    // 4
    // 2 6
    private static void bfsHelper(TreeNode root, List<List<TreeNode>> res, int level) {
        // terminal
        if (root == null) return;
        // do
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root);
        // recursive calls
        if (root.left != null) bfsHelper(root.left, res, level + 1);
        if (root.right != null) bfsHelper(root.right, res, level + 1);
    }

    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(4); TreeNode n2 = new TreeNode(2); TreeNode n3 = new TreeNode(3);
        TreeNode n1 = new TreeNode(1); TreeNode n5 = new TreeNode(5); TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n4.left = n2; n4.right = n6;
        n2.left = n1; n2.right = n3;
        n6.left = n5; n6.right = n7;
        //inorderIterative(n4);
        BFS(n4);

    }

    public static List<TreeNode> inorderIterative(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !st.empty()) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            System.out.print(cur.val + " ");
            res.add(cur);
            cur = cur.right;
        }
        return res;
    }

    // recursive
    public void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    public void preorderTraversal(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
}