package medium;

import java.util.Arrays;

public class Solution1129 {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        int[][] edge = new int[n][n], red_start = new int[n][n], blue_start = new int[n][n];
        for (int[] red : red_edges)
            edge[red[0]][red[1]] = 1;
        for (int[] blue : blue_edges)
            edge[blue[0]][blue[1]] = 2;
        for (int[] red : red_start)
            Arrays.fill(red, -1);
        for (int[] blue : blue_start)
            Arrays.fill(blue, -1);
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                }
            }
        }
        return null;
    }
}
