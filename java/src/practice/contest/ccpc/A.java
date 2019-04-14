package practice.contest.ccpc;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * n个2050
 */
public class A {
    public static void main(String[] args) {
        Scanner s
//                = new Scanner(System.in);
                = new Scanner(
                "0\n" +
                        "2050\n" +
                        "205020\n");
        int T = s.nextInt();
        s.nextLine();
        Pattern p = Pattern.compile("(2050)+");
        while (T-- > 0) {
            if (p.matcher(s.nextLine()).matches()) System.out.println("Yes");
//            if (match(s.nextLine())) System.out.println("Yes");
            else System.out.println("No");
        }
    }

    private static boolean match(String s) {
        if (s.length() % 4 != 0) return false;
        char[] r = {'2', '0', '5', '0'};
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) != r[i % 4]) return false;
        return true;
    }
}
