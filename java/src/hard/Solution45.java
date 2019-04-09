package hard;

public class Solution45 {
    public int jump(int[] nums) {
        int jump = 0, start = 0, end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (end >= nums.length - 1) return jump;
            if (start == i) {
                start = ++end;
                jump++;
            }
            end = Math.max(end, nums[i] + i);
        }
        return jump;
    }

    public static void main(String[] args) {
        int[] test = new int[25002];
        for (int i = 0; i < 25001; i++)
            test[i] = 25000 - i;
        test[25000] = 1;
        long t = System.currentTimeMillis();
        System.out.println(new Solution45().jump(test));
        System.out.println(System.currentTimeMillis() - t);
//        System.out.println(new Solution().jump(new int[]{7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3}));
    }
}