package hard;

import java.util.Arrays;

public class Solution1168 {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        Weight[] list = new Weight[n + pipes.length];
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            f[i] = i;
            list[i - 1] = new Weight(0, i, wells[i - 1]);
        }
        for (int i = 0; i < pipes.length; i++) {
            list[i + n] = new Weight(pipes[i][0], pipes[i][1], pipes[i][2]);
        }
        Arrays.sort(list);
        int cost = 0;
        for (Weight w : list) {
            if (father(f, w.a) == father(f, w.b)) continue;
            cost += w.w;
            f[father(f, w.a)] = father(f, w.b);
        }
        return cost;
    }

    private int father(int f[], int x) {
        return f[x] == x ? x : (f[x] = father(f, f[x]));
    }
}

class Weight implements Comparable<Weight> {

    final int w, a, b;

    Weight(int a, int b, int w) {
        this.w = w;
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Weight o) {
        return w - o.w;
    }
}