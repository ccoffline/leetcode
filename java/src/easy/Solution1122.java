package easy;

import java.util.Arrays;

public class Solution1122 {

    public static void main(String[] args) {

    }

    private static final int MAX_VAL = 1000;

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int last = arr1.length;
        int[] result = new int[last];
        int[] map = new int[MAX_VAL + 1];
        Arrays.fill(map, -1);
        for (int value : arr2)
            map[value] = 0;
        for (int value : arr1)
            if (map[value] < 0)
                result[--last] = value;
            else ++map[value];
        Arrays.sort(result, last, arr1.length);
        last = 0;
        for (int value : arr2)
            Arrays.fill(result, last, last += map[value], value);
        return result;
    }
}
