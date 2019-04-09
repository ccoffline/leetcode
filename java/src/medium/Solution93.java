package medium;

import java.util.LinkedList;
import java.util.List;

public class Solution93 {

    public static void main(String[] args) {
        Solution93 s = new Solution93();
        String[] cases = {"25525511135"};
        for (String c : cases) System.out.println(s.restoreIpAddresses(c));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<>();
        char dot = '.';
        int len = s.length(), max = Math.min(len - 2, 6);
        for (int mid = Math.max(2, len - 6); mid <= max; mid++) {
            List<Integer> p = new LinkedList<>(), n = new LinkedList<>();

            int temp = Math.min(mid - 1, 3);
            for (int i = Math.max(1, mid - 3); i <= temp; i++)
                if (isByte(s, 0, i) && isByte(s, i, mid))
                    p.add(i);
            if (p.isEmpty()) continue;
            temp = Math.min(len - 1, mid + 3);
            for (int i = Math.max(mid + 1, len - 3); i <= temp; i++)
                if (isByte(s, mid, i) && isByte(s, i, len))
                    n.add(i);
            if (n.isEmpty()) continue;

            for (int a : p)
                for (int b : n)
                    result.add(new StringBuilder(s).insert(b, dot).insert(mid, dot).insert(a, dot).toString());
        }
        return result;
    }

    private static boolean isByte(String s, int x, int y) {
        switch (y - x) {
            case 1:
                return true;
            case 2:
                return s.charAt(x) != '0';
            case 3:
                break;
            default:
                return false;
        }
        switch (s.charAt(x)) {
            case '1':
                return true;
            case '2':
                break;
            default:
                return false;
        }
        char c = s.charAt(x + 1);
        if (c < '5') return true;
        if (c > '5') return false;
        return s.charAt(x + 2) <= '5';
    }
}
