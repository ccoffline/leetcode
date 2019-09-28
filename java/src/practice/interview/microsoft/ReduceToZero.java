package practice.interview.microsoft;

import java.util.Arrays;

/**
 * 给一个数x，通过n步可以变成1
 * 每一步要么减1，要么换成最大的质因数，不能是1或者本身
 * 求n的最小值
 */
public class ReduceToZero {

    public static void main(String[] args) {
//        System.out.println(new ReduceToZero().step(9));
        System.out.println(new ReduceToZero().step(20));
    }

    public int step(int input) {
        int[] a = new int[input + 1];
        boolean[] b = new boolean[input + 1];
        Arrays.fill(a, Integer.MAX_VALUE);
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i <= input; i++) {
            a[i] = Math.min(a[i], a[i - 1] + 1);
            int k;
            for (int j = 2; j <= i && (k = j * i) <= input; j++) {
                b[k] = true;
                if (!b[i]) a[k] = Math.min(a[k], a[i] + 1);
            }
        }
        return a[input];
    }
}
