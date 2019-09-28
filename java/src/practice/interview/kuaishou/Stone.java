package practice.interview.kuaishou;

import java.util.Scanner;

/**
 * n个石头，每个石头有一定质量
 * 俩石头撞一下变成一个，质量为两者之差（或者撞没了）
 * 求最后质量最小可以是多少
 */
public class Stone {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] m = new int[n];
        for (int i = 0; i < n; i++) m[i] = in.nextInt();

    }
}
