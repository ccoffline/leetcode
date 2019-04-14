package practice.contest.ccpc;

import java.util.Scanner;

public class F {

    public static void main(String[] args) {
        Scanner s
                = new Scanner(System.in);
//                = new Scanner(
//                "2\n" +
//                        "3 10\n" +
//                        "1 2 0\n" +
//                        "4 8 3\n" +
//                        "6 10 1\n" +
//                        "2 1\n" +
//                        "1 1 1\n" +
//                        "1 1 1");

        int T = s.nextInt();
        while (T-- > 0) {
            Challenge[] challenges = new Challenge[s.nextInt()];
            Challenge temp;
            long strength = s.nextInt();
            for (int i = 0; i < challenges.length; i++) {
                temp = new Challenge(s.nextInt(), s.nextInt(), s.nextInt(), strength);
                strength += temp.c;
                challenges[i] = temp;
            }
            System.out.println(challenge(challenges));
        }
    }

    private static int challenge(Challenge[] challenges) {
        int min = 0, count = 0;
        Challenge temp;
        for (int i = challenges.length - 1; i >= 0; --i) {
            temp = challenges[i];
            if (Math.min(temp.left, temp.b) <= temp.a) continue;
            if (Math.min(temp.left, temp.b) - temp.a + temp.c <= min) continue;
            ++count;
            min = Math.max(temp.a, min - temp.c + temp.a);
        }
        return count;
    }

    private static class Challenge {
        int a, b, c;
        long left;

        Challenge(int a, int b, int c, long left) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.left = left;
        }
    }
}
