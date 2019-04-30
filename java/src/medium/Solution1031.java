package medium;

public class Solution1031 {

    public static void main(String[] args) {
    }

    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        return Math.max(max(A, L, A.length - M - 1), max(A, M, A.length - L - 1));
    }

    private int max(int[] A, int start, int end) {
        int gap = end - start + 2, count;
        int[] left = new int[gap], right = new int[gap];
        count = 0;
        for (int i = 0; i < start; i++) count += A[i];
        left[0] = count;
        for (int i = start; i <= end; i++)
            left[i - start + 1] = Math.max(left[i - start], count += A[i] - A[i - start]);
        count = 0;
        for (int i = A.length - 1; i > end; i--) count += A[i];
        right[gap - 1] = count;
        for (int i = end; i >= start; i--)
            right[i - start] = Math.max(right[i - start + 1], count += A[i] - A[i + A.length - end - 1]);
        count = 0;
        for (int i = 0; i < gap; i++) count = Math.max(count, left[i] + right[i]);
        return count;
    }
}
