//package hard;
//
//import java.util.*;
//
//public class Solution321 {
//
//    static class Test {
//        final int[] nums1, nums2;
//        final int k;
//
//        Test(int[] nums1, int[] nums2, int k) {
//            this.nums1 = nums1;
//            this.nums2 = nums2;
//            this.k = k;
//        }
//    }
//
//    public static void main(String[] args) {
//        Solution321 s = new Solution321();
//        Test[] cases = {
//                new Test(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5),
//                new Test(new int[]{6, 7}, new int[]{6, 0, 4}, 5),
//                new Test(new int[]{3, 9}, new int[]{8, 9}, 3),
//        };
//        for (Test t : cases)
//            System.out.println(Arrays.toString(s.maxNumber(t.nums1, t.nums2, t.k)));
//    }
//
//    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
//        Deque<Integer>[] pq1 = new Deque[10], pq2 = new Deque[10];
//        Deque<Integer> q;
//        for (int i = 0; i < nums1.length; i++) {
//            if ((q = pq1[nums1[i]]) == null) pq1[nums1[i]] = q = new LinkedList<>();
//            q.addLast(i);
//        }
//        for (int i = 0; i < nums2.length; i++) {
//            if ((q = pq2[nums1[i]]) == null) pq2[nums1[i]] = q = new LinkedList<>();
//            q.addLast(i);
//        }
//        int total = nums1.length + nums2.length, x = 0, y = 0, count = 0, temp, a, b;
//        int[] result = new int[k];
//        for (int i = 9; i > 0; i--) {
//            temp = 0;
//            if ((q = pq1[i]) != null) {
//                temp += q.size();
//                x = q.getLast();
//            }
//            if ((q = pq2[i]) != null) {
//                temp += q.size();
//                y = q.getLast();
//            }
//        }
//    }
//}
