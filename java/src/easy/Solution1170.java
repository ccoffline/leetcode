package easy;

import java.util.Arrays;

public class Solution1170 {
    public static void main(String[] args) {
        Solution1170 solution = new Solution1170();
        System.out.println(Arrays.toString(
                solution.numSmallerByFrequency(new String[]{"cbd"}, new String[]{"zaaaz"})));
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] q = new int[queries.length];
        int[] w = new int[words.length];
        for (int i = 0; i < w.length; i++) w[i] = f(words[i]);
        Arrays.sort(w);
        for (int i = 0; i < q.length; i++) {
            q[i] = f(queries[i]);
            int count = 0;
            for (int j = w.length - 1; j >= 0; j--) {
                if (q[i] >= w[j]) break;
                count++;
            }
            q[i] = count;
        }
        return q;
    }

    private int f(String s) {
        int count = 0;
        char min = Character.MAX_VALUE;
        for (char c : s.toCharArray()) {
            if (c < min) {
                min = c;
                count = 1;
            } else if (c == min)
                count++;
        }
        return count;
    }
}
