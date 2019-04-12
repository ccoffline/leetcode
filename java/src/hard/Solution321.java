package hard;

import java.util.*;

public class Solution321 {

    static class Test {
        final int[] nums1, nums2;
        final int k;

        Test(int[] nums1, int[] nums2, int k) {
            this.nums1 = nums1;
            this.nums2 = nums2;
            this.k = k;
        }
    }

    public static void main(String[] args) {
        Solution321 s = new Solution321();
        Test[] cases = {
                new Test(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5),
                new Test(new int[]{6, 7}, new int[]{6, 0, 4}, 5),
                new Test(new int[]{3, 9}, new int[]{8, 9}, 3),
        };
        for (Test t : cases)
            System.out.println(Arrays.toString(s.maxNumber(t.nums1, t.nums2, t.k)));
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[][] hash1 = new int[10][nums1.length + 1], hash2 = new int[10][nums2.length + 1];
        for (int i = 0; i < nums1.length; i++)
            addPosition(hash1[nums1[i]], i);
        for (int i = 0; i < nums2.length; i++)
            addPosition(hash2[nums2[i]], i);
        int[] result = new int[k];
        int x = 0, y = 0, count = 0, top = 10;
        for (int i = 9; i > 0; i--) {
            int size1 = countSize(hash1[i], x), size2 = countSize(hash2[i], y);
            if (size1 + size2 >= k - count) {
                Arrays.fill(result, count, k, i);
                break;
            }
            int last1 = getLast(hash1[i], x), last2 = getLast(hash2[i], y);
            int remain = (k - count - size1 - size2) // 还需要数字的个数
                    - (nums1.length - last1 + nums2.length - last2); // 剩余数字的个数
            if (remain <= 0) {
                Arrays.fill(result, count, count += size1 + size2, i);
                continue;
            }
            int take1 = Math.max(0, size1 - remain), take2 = Math.max(0, size2 - remain);
            Arrays.fill(result, count, count += take1 + take2, i);
            x = firstRemain(hash1[i], size1 - take1);
            y = firstRemain(hash2[i], size2 - take2);
        }
        return result;
    }

    private void addPosition(int[] a, int pos) {
        a[++a[0]] = pos;
    }

    private int countSize(int[] a, int start) {
        int size = a[0], i = 0;
        while (size > 0 && a[++i] < start) size--;
        return size;
    }

    private int getLast(int[] a, int start) {
        return Math.max(a[a[0]], start);
    }

    private int firstRemain(int[] a, int remain) {
        return a[a[0] - remain];
    }
}
