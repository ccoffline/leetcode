package practice.contest.bjtu;

import java.util.*;

public class J {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
//        Scanner s = new Scanner(
//                "6 5\n" +
//                        "1 2\n" +
//                        "2 3\n" +
//                        "3 4\n" +
//                        "2 5\n" +
//                        "3 6\n"
//        );

        int n = s.nextInt(), k = s.nextInt();
        List<List<Integer>> nodes = new ArrayList<>(n);
        int[] height = new int[n];
        for (int i = 0; i < n; i++) nodes.add(new LinkedList<>());
        while (--n > 0) {
            int a = s.nextInt() - 1, b = s.nextInt() - 1;
            nodes.get(a).add(b);
            nodes.get(b).add(a);
        }
        int d = findDeepest(findDeepest(0, height, nodes), height, nodes);
        d = height[d] + 1;
        if (k > d) System.out.println(2 * (k - d) + d - 1);
        else System.out.println(k - 1);
    }

    private static int findDeepest(int index, int[] height, List<List<Integer>> nodes) {
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(height, -1);
        height[index] = 0;
        q.add(index);
        while (!q.isEmpty()) {
            index = q.remove();
            for (int next : nodes.get(index))
                if (height[next] < 0) {
                    height[next] = height[index] + 1;
                    q.add(next);
                }
        }
        return index;
    }
}
