package practice.contest.leetcode;

public class Solution5131 {
    public static void main(String[] args) {
        int[][] cases = {
                {6, 2, 4},
        };
        Solution5131 solution = new Solution5131();
        for (int[] c : cases)
            System.out.println(solution.mctFromLeafValues(c));
    }

    public int mctFromLeafValues(int[] arr) {
        int[][] sum = new int[arr.length][arr.length], max = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            int temp = Integer.MIN_VALUE;
            for (int j = i; j < arr.length; j++) {
                max[i][j] = temp = Math.max(arr[j], temp);
            }
        }
        for (int len = 0; len < arr.length; len++) {
            for (int j = len; j < arr.length; j++) {
                int i = j - len;
                for (int k = i; k < j; k++) {
                    int temp = sum[i][k] + sum[k + 1][j] + max[i][k] * max[k + 1][j];
                    if (sum[i][j] == 0 || sum[i][j] > temp)
                        sum[i][j] = temp;
                }
            }
        }
        return sum[0][arr.length - 1];
    }
}
