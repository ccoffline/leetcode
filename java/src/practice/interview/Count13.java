package practice.interview;

import java.util.Scanner;

/**
 * 杭州电子OJ
 * 给定一个整数N，求从1-N之间数字包含13并且能被13整除的个数
 */
public class Count13 {

    public static void main(String[] args) {
        System.out.println(new Count13().count(new Scanner(System.in).nextLong()));
    }

    public long count(long N) {
        // 100 % 13 = 9
        // [i][j]为 i + 1 位数字中余数为 j 且包含/不包含13的个数
        long[][] include = new long[18][13], exclude = new long[18][13];
        for (int i = 0; i < 10; i++) exclude[0][i] = 1;
        return 0;
    }
}