package practice.contest.leetcode;

public class Solution5129 {

    public static void main(String[] args) {
        int[][] cases = {
                {9, 9, 6, 0, 6, 6, 9},
                {6, 9, 9}
        };
        Solution5129 solution = new Solution5129();
        int i = 0;
        while (i < cases.length)
            System.out.println(solution.longestWPI(cases[i++]));
    }

    public int longestWPI(int[] hours) {
        int max = 0;
        for (int i = 0; i < hours.length; i++) {
            int temp = 0;
            hours[i] = hours[i] > 8 ? 1 : -1;
            for (int j = i; j >= 0; j--) {
                temp += hours[j];
                if (temp > 0)
                    max = Math.max(max, i - j + 1);
            }
        }
        return max;
    }
}
