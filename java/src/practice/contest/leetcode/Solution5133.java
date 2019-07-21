package practice.contest.leetcode;

import java.util.Arrays;

public class Solution5133 {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int len = arr1.length, max = 0;
        Node[] n1 = new Node[len], n2 = new Node[len];
        for (int i = 0; i < len; i++) {
            n1[i] = new Node(arr1[i], i);
            n2[i] = new Node(arr2[i], i);
        }
        Arrays.sort(n1);
        Arrays.sort(n2);
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                max = Math.max(max, Math.abs(arr1[i] - arr1[j]) + Math.abs(arr2[i] - arr2[j]) + j - i);
            }
        }
        return max;
    }

    static class Node implements Comparable<Node> {
        int val;
        int pos;

        Node(int val, int pos) {
            this.val = val;
            this.pos = pos;
        }

        public int compareTo(Node o) {
            return val - o.val;
        }
    }
}