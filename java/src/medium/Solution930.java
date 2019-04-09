package medium;

public class Solution930 {

    public int numSubarraysWithSum(int[] A, int S) {
        int count = 0, i = 0, ans = 0;
        if (S == 0) {
            while (i < A.length) {
                if (A[i++] == 1) {
                    ans += count++ * count / 2;
                    count = 0;
                } else count++;
            }
            return ans + count++ * count / 2;
        }
        while (S > 0) {
            if (i == A.length) return 0;
            else if (A[i++] == 1) S--;
        }
        int j = 0;
        while (i < A.length) {
            do count++; while (i < A.length && A[i++] == 0);
            do ans += count; while (A[j++] == 0);
            count = 0;
        }
        if (A[i - 1] == 1) do ans++; while (A[j++] == 0);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution930().numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
    }
}
