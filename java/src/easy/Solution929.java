package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class Solution929 {

    public static void main(String[] args) {
        Solution929 s = new Solution929();
        String[][] cases = {
                {
                        "test.email+alex@leetcode.com",
                        "test.e.mail+bob.cathy@leetcode.com",
                        "testemail+david@lee.tcode.com"
                }
        };
        for (String[] c : cases) System.out.println(s.numUniqueEmails(c));
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> domain = new HashSet<>();
        for (String email : emails) {
            StringBuilder builder = new StringBuilder();
            int i = 0;
            char c;
            for (; (c = email.charAt(i)) != '@'; i++) {
                if (c == '.') continue;
                if (c == '+') break;
                builder.append(c);
            }
            while (email.charAt(i) != '@') ++i;
            domain.add(builder.append(email.substring(i)).toString());
        }
        return domain.size();
    }
}
