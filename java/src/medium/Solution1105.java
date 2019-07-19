package medium;

import java.util.Arrays;

public class Solution1105 {

    public static void main(String[] args) {
        int[][][] books = {
                {{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}}
        };
        int[] widths = {
                4
        };
        Solution1105 solution = new Solution1105();
        for (int i = 0; i < books.length; i++) {
            System.out.println(solution.minHeightShelves(books[i], widths[i]));
        }
    }

    public int minHeightShelves(int[][] books, int shelf_width) {
        int[][] heights = new int[books.length][books.length];
        Arrays.fill(heights[0], Integer.MAX_VALUE);
        for (int i = 0; i < books.length; ++i) {
            int width = 0, height = 0;
            for (int j = i; j < books.length; ++j) {
                width += books[j][0];
                if (width > shelf_width) break;
                heights[i][j] = height = Math.max(height, books[j][1]);
                if (i > 0)
                    heights[0][j] = Math.min(heights[0][j], height + heights[0][i - 1]);
            }
        }
        return heights[0][books.length - 1];
    }
}
