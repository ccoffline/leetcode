package hard;

import java.util.*;
import java.util.function.BiFunction;

public class Solution30 {
    public static void main(String[] args) {
        Solution30 s
                = new Solution30();
//                = new Solution30V2();
        System.out.println(s.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(s.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}));
        System.out.println(s.findSubstring("ababaab", new String[]{"ab", "ba", "ba"}));
        System.out.println(s.findSubstring("aaaaaaaa", new String[]{"aa", "aa", "aa"}));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new LinkedList<>();
        if (words.length == 0 || s.length() < words[0].length() * words.length) return result;
        int x = words[0].length() - 1, y = s.length() - x;
        char c;
        Map wordMap = new TreeMap();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Map temp = wordMap, next;
            for (int j = 0; j < x; j++) {
                next = (Map) temp.get(c = word.charAt(j));
                if (next == null)
                    temp.put(c, next = new TreeMap());
                temp = next;
            }
            Integer count = (Integer) temp.get(c = word.charAt(x));
            if (count == null) count = 1;
            else count++;
            temp.put(c, count);
        }
        Map[] match = new Map[y];
        for (int i = 0; i < x; i++) {
            c = s.charAt(i);
            match[i] = wordMap;
            for (int j = 0; j <= i; j++)
                if (match[j] != null)
                    match[j] = (Map) match[j].get(c);
        }
        for (int i = 0; i < y; i++) {
            int max = i + x;
            c = s.charAt(i + x);
            if (max < y) match[max] = wordMap;
            else max = y - 1;
            for (int j = i + 1; j <= max; j++)
                if (match[j] != null)
                    match[j] = (Map) match[j].get(c);
        }
        for (int i = 0; i <= x; i++) {
            int start = i, temp;
            for (int j = i; j < y; j += x + 1) {
                if (match[j] == null || !match[j].containsKey(c = s.charAt(j + x))) {
                    while (start < j) {
                        temp = (int) match[start].get(c = s.charAt(start + x));
                        match[start].put(c, temp + 1);
                        start += x + 1;
                    }
                    start += x + 1;
                    continue;
                }
                match[j].put(c, (int) match[j].get(c) - 1);
                if ((int) match[j].get(s.charAt(j + x)) < 0)
                    while ((int) match[j].get(s.charAt(j + x)) < 0) {
                        temp = (int) match[start].get(c = s.charAt(start + x));
                        match[start].put(c, temp + 1);
                        start += x + 1;
                    }
                else if (j - start == (words.length - 1) * (x + 1)) {
                    result.add(start);
                    temp = (int) match[start].get(c = s.charAt(start + x));
                    match[start].put(c, temp + 1);
                    start += x + 1;
                }
            }
            while (start < y) {
                temp = (int) match[start].get(c = s.charAt(start + x));
                match[start].put(c, temp + 1);
                start += x + 1;
            }
        }
        return result;
    }
}

class Solution30V2 extends Solution30 {

    @Override
    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> result = new ArrayList<>();
        if (words.length == 0) return result;
        int len = words[0].length();
        int amount = words.length;
        int all = len * amount;
        if (len == 0) {
            for (int i = 0; i <= s.length(); i++) result.add(i);
            return result;
        }
        Map<String, Integer> count = new HashMap<>(), temp = new HashMap<>();
        for (String word : words)
            count.put(word, count.getOrDefault(word, 0) + 1);
        String firstWord, part;
        for (int i = 0, j, k; i < len; i++) {
            temp.clear();
            j = i;
            k = 0;
            while (j < s.length()) {
                while (k < all && j + k + len <= s.length()) {
                    part = s.substring(j + k, j + k + len);
                    if (count.containsKey(part)) {
                        temp.put(part, temp.getOrDefault(part, 0) + 1);
                        if (temp.get(part) > count.get(part)) {
                            // move until valid
                            while (temp.get(part) > count.get(part)) {
                                firstWord = s.substring(j, j + len);
                                temp.put(firstWord, temp.getOrDefault(firstWord, 0) - 1);
                                k -= len;
                                j += len;
                            }
                        }
                        k += len;
                    } else {
                        // comes out illegal part
                        temp.clear();
                        j = j + k + len;
                        k = 0;
                    }
                }
                // all match
                if (k == all) {
                    result.add(j);
                    firstWord = s.substring(j, j + len);
                    temp.put(firstWord, temp.getOrDefault(firstWord, 0) - 1);
                    k -= len;
                }
                j += len;
            }
        }
        return result;
    }
}