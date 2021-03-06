package medium;

import java.util.PriorityQueue;

public class Solution1167 {
    public int connectSticks(int[] sticks) {
        int ans = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int s : sticks)
            q.add(s);
        while (q.size() > 1) {
            int x = q.remove() + q.remove();
            ans += x;
            q.add(x);
        }
        return ans;
    }
}
