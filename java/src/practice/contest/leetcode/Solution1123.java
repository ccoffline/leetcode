package practice.contest.leetcode;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution1123 {

    public static void main(String[] args) {
//        Integer[][] cases = {
//                {1, 2, 3},
//                {1, 2, 3, 4},
//                {1, 2, 3, 4, 5}
//        };
//        int i = 0;
//        while (i < cases.length) {
//
//        }

        Solution1123 solution = new Solution1123();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.left.right = new TreeNode(6);
        TreeNode result = solution.lcaDeepestLeaves(root);
        System.out.println(result.val);
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        getDeepest(root, 0);
        return result;
    }

    private int max = 0;
    private TreeNode result;

    private int getDeepest(TreeNode root, int height) {
        if (root == null) return height - 1;
        max = Math.max(max, height);
        int d1 = getDeepest(root.left, height + 1), d2 = getDeepest(root.right, height + 1);
        if (d1 == max && d2 == max)
            result = root;
        if (d1 == max || d2 == max)
            return max;
        return height;
    }
}
