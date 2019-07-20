package hard;

import java.util.Arrays;
import java.util.Comparator;

public class Solution1095 {

    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3, 4, 5, 3, 1},
                {0, 1, 2, 4, 2, 1},
                {1, 5, 2},
                {1, 5, 2}
        };
        int[] targets = {
                3,
                3,
                1,
                2,
        };
        Solution1095 solution = new Solution1095();
        for (int i = 0; i < array.length; i++) {
            System.out.println(solution.findInMountainArray(targets[i], new MA(array[i])));
        }
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        m = mountainArr;
        int len = m.length();
        a = new int[len];
        Arrays.fill(a, -1);

        int left = 0, right = len - 1;
        while (left < right) {
            int temp = (left + right) / 2;
            if (get(temp) < get(temp + 1))
                left = temp + 1;
            else
                right = temp;
        }
        if (get(left) == target) return left;
        int temp = find(0, left, target, up);
        if (temp < 0) temp = find(left, len - 1, target, down);
        return temp;
    }

    private int[] a;
    private MountainArray m;

    private int get(int index) {
        if (a[index] < 0)
            a[index] = m.get(index);
        return a[index];
    }

    private int find(int left, int right, int target, Comparator<Integer> c) {
        while (true) {
            int temp = (left + right) / 2;
            int value = get(temp);
            if (value == target) return temp;
            if (left == right) return -1;
            if (c.compare(value, target) < 0) left = temp + 1;
            else right = temp;
        }
    }

    private static final Comparator<Integer> up = Comparator.comparingInt(a -> a);
    private static final Comparator<Integer> down = Comparator.comparingInt(a -> -a);
}

interface MountainArray {

    int get(int index);

    int length();
}

class MA implements MountainArray {

    private int[] a;
    private int count = 0;

    MA(int[] array) {
        a = array;
    }

    @Override
    public int get(int index) {
        if (++count > 100) throw new RuntimeException("fuck you");
        return a[index];
    }

    @Override
    public int length() {
        return a.length;
    }
}