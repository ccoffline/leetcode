package easy;

import java.util.Arrays;

public class Solution1103 {
    public static void main(String[] args) {
        int[] cases = {
                7, 4,
                10, 3,
                1000000000, 1000
        };
        Solution1103 solution = new Solution1103();
        int i = 0;
        while (i < cases.length) {
            System.out.println(Arrays.toString(solution.distributeCandies(cases[i++], cases[i++])));
        }
    }

    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        // cast into double (8.0 * candies)
        int turn = (int) (Math.sqrt(8.0 * candies + 1) - 1) / num_people / 2;
        for (int i = 0; i < num_people; ++i)
            candies -= result[i] = (i + 1) * turn + (turn - 1) * turn * num_people / 2;
        int count = turn * num_people;
        for (int i = 0; i < num_people; ++i) {
            if (++count > candies) {
                result[i] += candies;
                break;
            }
            result[i] += count;
            candies -= count;
        }
        return result;
    }
}
