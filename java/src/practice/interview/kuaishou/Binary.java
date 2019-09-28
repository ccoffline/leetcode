package practice.interview.kuaishou;

import java.util.Scanner;

/**
 * 一个二进制串，其中含有k个1的子串的个数
 */
public class Binary {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = Integer.parseInt(in.nextLine());
        char[] c = in.nextLine().toCharArray();
        int[] p = new int[c.length];
        int[] n = new int[c.length];
        int count = 0, j = -1, temp = -1;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '0') continue;
            if (j > -1) n[j] = i;
            if (temp < 0) temp = i;
            p[i] = j;
            j = i;
            if (k == 0) {
                count += (temp - p[temp]) * (i - p[i]);
                temp = n[temp];
            } else k--;
        }
        if (k == 0)
            count += (temp - p[temp]) * (c.length - j);
        System.out.println(count);
    }
}