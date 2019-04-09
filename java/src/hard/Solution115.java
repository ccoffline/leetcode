package hard;

import java.util.*;
import java.util.function.Function;

public class Solution115 {

    public static void main(String[] args) {
        Solution115 s
//                = new Solution115();
//                = new Solution115V2();
//                = new Solution115V3();
//                = new Solution115V4();
                = new Solution115V5();
        String[][] cases = {
                {"rabbbit", "rabbit"},
                {"babgbag", "bag"}
        };
        for (String[] c : cases) System.out.println(s.numDistinct(c[0], c[1]));
    }

    public int numDistinct(String s, String t) {
        this.s = s.toCharArray();
        this.t = t.toCharArray();
        return compare(0, 0);
    }

    char[] s, t;

    int compare(int s, int t) {
        if (t == this.t.length) return 1;
        char c = this.t[t];
        int count = 0;
        for (int i = s; i < this.s.length; i++)
            if (this.s[i] == c) count += compare(i + 1, t + 1);
        return count;
    }
}

class Solution115V2 extends Solution115 {
    public int numDistinct(String s, String t) {
        if (t.isEmpty() || s.length() < t.length()) return 0;
        int[] count = new int[s.length()], next = new int[s.length()], temp;
        char c;
        Arrays.fill(next, 1);
        for (int i = 0; i < t.length(); i++) {
            c = t.charAt(i);
            temp = count;
            count = next;
            next = temp;
            Arrays.fill(next, 0);
            if (s.charAt(i) == c)
                next[i] = i == 0 ? 1 : count[i - 1];

            for (int j = i + 1; j < s.length(); j++) {
                next[j] = next[j - 1];
                if (s.charAt(j) == c) next[j] += count[j - 1];
            }
        }
        return next[s.length() - 1];
    }
}

class Solution115V3 extends Solution115 {
    public int numDistinct(String s, String t) {
        int[][] hash = new int[256][t.length() + 1];
        int[] cnt = new int[t.length() + 1];
        cnt[0] = 1;
        for (int i = 0; i < t.length(); ) {
            char c = t.charAt(i);
            hash[c][++hash[c][0]] = ++i;
        }
        for (char c : s.toCharArray()) {
            for (int i = hash[c][0]; i > 0; i--) {
                cnt[hash[c][i]] += cnt[hash[c][i] - 1];
            }
        }
        return cnt[t.length()];
    }
}

class Solution115V4 extends Solution115 {
    public int numDistinct(String s, String t) {
        int[] count = new int[t.length() + 1];
        count[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = t.length() - 1; j >= 0; j--)
                if (t.charAt(j) == c)
                    count[j + 1] += count[j];
        }
        return count[t.length()];
    }
}

class Solution115V5 extends Solution115 {
    public int numDistinct(String s, String t) {
        Map<Character, LinkedList<Integer>> pos = new HashMap<>();
        LinkedList<Integer> dft = new LinkedList<>();
        for (int i = 0; i < t.length(); i++)
            pos.computeIfAbsent(t.charAt(i), lambda).addFirst(i);

        int[] count = new int[t.length() + 1];
        count[0] = 1;
        for (int i = 0; i < s.length(); i++)
            for (int p : pos.getOrDefault(s.charAt(i), dft))
                count[p + 1] += count[p];

        return count[t.length()];
    }

    static final Function<Character, LinkedList<Integer>> lambda = k -> new LinkedList<>();
}
