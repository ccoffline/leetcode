package hard;

public class Solution4 {

    public static void main(String[] args) {
        int[][] cases = {
                {1, 3},
                {2},
                {1, 2},
                {3, 4},
                {3},
                {-2, -1},
                {1, 2},
                {-1, 3},
                {1, 2},
                {3, 4, 5}
        };
        Solution4 solution = new Solution4();
        int i = 0;
        while (i < cases.length)
            System.out.println(solution.findMedianSortedArrays(cases[i++], cases[i++]));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        if (nums1.length == 0)
            return (nums2[nums2.length / 2] + nums2[(nums2.length - 1) / 2]) * 0.5;
        int left = 0;
        int right = nums1.length - 1;
        int total = nums1.length + nums2.length;
        if (total % 2 == 0) {
            int sub = total / 2 - 1;
            while (true) {
                int mid = (left + right) / 2;
                int temp1 = nums1[mid];
                int temp2 = nums2[sub - mid];
                if (temp1 == temp2) return temp1;
                if (temp1 < temp2) {
                    if (left == right) {
                        left = sub - mid - 1;
                        right = mid + 1;
                        if (left >= 0 && nums2[left] > temp1) temp1 = nums2[left];
                        if (right < nums1.length && nums1[right] < temp2) temp2 = nums1[right];
                        return (temp1 + temp2) * 0.5;
                    }
                    left = mid + 1;
                } else {
                    if (left == right) {
                        left = mid - 1;
                        right = sub - mid + 1;
                        if (left >= 0 && nums1[left] > temp2) temp2 = nums1[left];
                        if (right < nums2.length && nums2[right] < temp1) temp1 = nums2[right];
                        return (temp1 + temp2) * 0.5;
                    }
                    right = mid;
                }
            }
        } else {
            int sub = total / 2 - 1;
            while (true) {
                int mid = (left + right) / 2;
                int temp1 = nums1[mid];
                int temp2 = nums2[sub - mid];
                int temp3 = nums2[sub - mid + 1];
                if (temp1 < temp2) {
                    if (left == right)
                        return temp2;
                    left = mid + 1;
                    continue;
                }
                if (temp1 > temp3) {
                    if (left == right)
                        return temp3;
                    right = mid;
                    continue;
                }
                return temp1;
            }
        }

    }
}
