package practice.contest.leetcode;

import java.util.Arrays;

public class Solution5130 {

    public static void main(String[] args) {
        Solution5130 solution = new Solution5130();
        int[][][] cases = {
//                {{1, 2}, {2, 1}, {3, 4}, {5, 6}, {2, 1}},
                {{2, 2}, {1, 2}, {1, 2}, {1, 1}, {1, 2}, {1, 1}, {2, 2}}
        };
        for (int[][] c : cases)
            System.out.println(solution.numEquivDominoPairs(c));
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        Domino[] array = new Domino[dominoes.length];
        for (int i = 0; i < dominoes.length; ++i)
            array[i] = new Domino(dominoes[i]);
        Arrays.sort(array);
        Domino temp = null;
        int count = 0, result = 0;
        for (Domino d : array) {
            if (!d.equals(temp)) {
                result += count * (count + 1) / 2;
                count = 0;
            } else
                ++count;
            temp = d;
        }
        return result + count * (count + 1) / 2;
    }
}

class Domino implements Comparable<Domino> {
    int a, b;

    Domino(int[] domino) {
        if (domino[0] > domino[1]) {
            a = domino[1];
            b = domino[0];
        } else {
            a = domino[0];
            b = domino[1];
        }
    }

    public int compareTo(Domino o) {
        if (a == o.a)
            return b - o.b;
        return a - o.a;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Domino domino = (Domino) o;
        if (a != domino.a) return false;
        return b == domino.b;
    }
}