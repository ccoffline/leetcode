package medium;

import java.util.LinkedList;
import java.util.List;

public class Solution1104 {

    public static void main(String[] args) {
        int[] cases = {
                14,
                26
        };
        Solution1104 solution = new Solution1104();
        for (int a : cases) {
            System.out.println(solution.pathInZigZagTree(a));
        }
    }

    public List<Integer> pathInZigZagTree(int label) {
        int depth = getDepth(label);
        List<Integer> result = new LinkedList<>();
        while (depth > 0) {
            result.add(0, label);
            if (--depth % 2 == 0) {
                label /= 2;
                label = 3 * (1 << (depth - 1)) - 1 - label;
            } else {
                label = 3 * (1 << depth) - 1 - label;
                label /= 2;
            }
        }
        return result;
    }

    private int getDepth(int label) {
        int depth = 0;
        while ((label >>= 1) > 0) ++depth;
        return depth + 1;
    }
}
