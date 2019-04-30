package practice.contest.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Solution1028 {

    public static void main(String[] args) {
        String[] cases = {"3", "1-2--3--4-5--6--7", "1-2--3---4-5--6---7", "1-401--349---90--88"};
        Solution1028 s = new Solution1028();
        for (String c : cases) {
            TreeNode root = s.recoverFromPreorder(c);
            List<Integer> print = new LinkedList<>();
            printTree(root, print);
            System.out.println(print);
        }
    }

    static void printTree(TreeNode node, List<Integer> print) {
        if (node == null) {
            print.add(null);
            return;
        }
        print.add(node.val);
        printTree(node.left, print);
        printTree(node.right, print);
    }

    int index;
    String[] heights, values;

    public TreeNode recoverFromPreorder(String S) {
        if (S.length() == 0) return null;
        else if (!S.contains("-")) return new TreeNode(Integer.parseInt(S));
        heights = S.split("\\d+");
        values = S.split("-+");
        index = 0;
        return recoverFromPreorder(0);
    }

    TreeNode recoverFromPreorder(int h) {
        if (index == heights.length || heights[index].length() != h++) return null;
        TreeNode node = new TreeNode(Integer.parseInt(values[index++]));
        node.left = recoverFromPreorder(h);
        node.right = recoverFromPreorder(h);
        return node;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}