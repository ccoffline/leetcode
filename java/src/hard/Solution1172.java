package hard;

import java.util.ArrayList;
import java.util.List;

public class Solution1172 {
    public static void main(String[] args) {
        Solution1172 solution = new Solution1172();
        String[][][] cases = {{
                {"DinnerPlates", "2"},
                {"push", "1"},
                {"push", "2"},
                {"push", "3"},
                {"push", "4"},
                {"push", "5"},
                {"popAtStack", "0", "2"},
                {"push", "20"},
                {"push", "21"},
                {"popAtStack", "0", "20"},
                {"popAtStack", "2", "21"},
                {"pop", "5"},
                {"pop", "4"},
                {"pop", "3"},
                {"pop", "1"},
                {"pop", "-1"},
        }
        };
        for (String[][] c : cases) {
            DinnerPlates plates = null;
            int expect, pop;
            for (String[] a : c) {
                switch (a[0]) {
                    case "DinnerPlates":
                        plates = new DinnerPlates(Integer.parseInt(a[1]));
                        System.out.println("capacity: " + a[1]);
                        break;
                    case "push":
                        plates.push(Integer.parseInt(a[1]));
                        System.out.println("push: " + a[1]);
                        break;
                    case "pop":
                        expect = Integer.parseInt(a[1]);
                        pop = plates.pop();
                        if (pop == expect)
                            System.out.println("pop: " + pop);
                        else
                            System.err.println("pop: " + pop + ", expect: " + a[1]);
                        break;
                    case "popAtStack":
                        expect = Integer.parseInt(a[2]);
                        pop = plates.popAtStack(Integer.parseInt(a[1]));
                        if (pop == expect)
                            System.out.println("pop: " + pop + " at stack: " + a[1]);
                        else
                            System.err.println("pop: " + pop + " at stack: " + a[1] + ", expect: " + a[2]);
                        break;
                }
            }
        }
    }
}


//class DinnerPlates {
//
//    private int cap;
//    private int last = -1;
//    private int[] stack = new int[200000];
//    private TreeSet<Integer> set = new TreeSet<>();
//
//    public DinnerPlates(int capacity) {
//        this.cap = capacity;
//    }
//
//    public void push(int val) {
//        if (set.isEmpty()) {
//            stack[++last] = val;
//        } else {
//            stack[set.pollFirst()] = val;
//        }
//    }
//
//    public int pop() {
//        if (last < 0) return -1;
//        int ans = stack[last--];
//        while (!set.isEmpty() && last == set.last()) {
//            set.pollLast();
//            last--;
//        }
//        return ans;
//    }
//
//    public int popAtStack(int index) {
//        int i = last / cap;
//        if (i < index) return -1;
//        else if (i == index) return pop();
//        i = index * cap;
//        Integer high = set.ceiling(i);
//        if (high != null && high == i) return -1;
//        i += cap;
//        if (high != null && high < i) {
//            set.add(--high);
//            return stack[high];
//        } else {
//            set.add(--i);
//            return stack[i];
//        }
//    }
//}

class DinnerPlates {

    private int left = 0, right = 0, size, cap;
    private int[][] list = new int[100000][];
    private int[] lens = new int[100000];

    public DinnerPlates(int capacity) {
        this.cap = capacity;
        list[size++] = new int[cap];
    }

    public void push(int val) {
        list[left][lens[left]++] = val;
        if (left > right) right = left;
        if (lens[left] == cap) {
            while (lens[left] >= cap) left++;
            if (left >= size) list[size++] = new int[cap];
        }
    }

    public int pop() {
        while (right >= 0 && lens[right] <= 0) right--;
        if (right == -1) {
            left = 0;
            return -1;
        }
        if (left > right) left = right;
        return list[right][--lens[right]];
    }

    public int popAtStack(int index) {
        if (index >= size) {
            return -1;
        }
        if (lens[index] <= 0) {
            return -1;
        }
        if (index < left) left = index;
        return list[index][--(lens[index])];
    }
}

/* fuck leetcode */
