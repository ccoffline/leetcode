package hard;

import java.util.HashMap;
import java.util.Map;

public class Solution76 {

    // Java中HashMap效率不高，确定键值范围是8位字符可以用256位数组代替Map
    public String minWindow(String s, String t) {
        Map<Character, Integer> required = new HashMap<>();
        for (int i = 0; i < t.length(); i++)
            if (required.computeIfPresent(t.charAt(i), (k, v) -> v + 1) == null)
                required.put(t.charAt(i), 1);

        int remains = required.size(), len = Integer.MAX_VALUE, temp = 0;
        Integer remain, start = null;
        for (int i = 0; i < s.length(); i++) {
            remain = required.computeIfPresent(s.charAt(i), (k, v) -> v - 1);
            if (remain == null || remain != 0 || --remains > 0) continue;
            do remain = required.computeIfPresent(s.charAt(temp++), (k, v) -> v + 1);
            while (remain == null || remain <= 0);
            if (len > i - temp + 2) {
                start = temp - 1;
                len = i - start + 1;
            }
            remains++;
        }
        if (start == null) return "";
        return s.substring(start, start + len);
    }

    public static void main(String[] args) {
//        System.out.println(new Solution76().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new Solution76().minWindow("cabwefgewcwaefgcf", "cae"));
    }
}
