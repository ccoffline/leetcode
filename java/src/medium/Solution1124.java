package medium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution1124 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("test.txt")));
        String line;
        List temp = new ArrayList();
        while ((line = reader.readLine()) != null) {
            String[] strings = line.split(",");
            int[] array = new int[strings.length];
            for (int i = 0; i < strings.length; i++)
                array[i] = Integer.parseInt(strings[i]);
            temp.add(array);
        }
        int[][] cases = new int[temp.size()][];
        for (int i = 0; i < temp.size(); i++)
            cases[i] = (int[]) temp.get(i);
        Solution1124 solution = new Solution1124(), bad = new BadSolution(), test = new TestSolution();
        int i = 0;
        long start;
        while (i < cases.length) {
            start = System.currentTimeMillis();
            System.out.println("good: " + solution.longestWPI(cases[i].clone()) + " " + (System.currentTimeMillis() - start) + "ms");
            start = System.currentTimeMillis();
            System.out.println("test: " + test.longestWPI(cases[i].clone()) + " " + (System.currentTimeMillis() - start) + "ms");
            start = System.currentTimeMillis();
            System.out.println("bad: " + bad.longestWPI(cases[i].clone()) + " " + (System.currentTimeMillis() - start) + "ms");
            i++;
        }
    }

    public int longestWPI(int[] hours) {
        int max = 0;
        for (int i = 0; i < hours.length; i++) {
            int temp = 0;
            hours[i] = hours[i] > 8 ? 1 : -1;
            for (int j = i; j >= 0; j--) {
                temp += hours[j];
                if (temp > 0)
                    max = Math.max(max, i - j + 1);
            }
        }
        return max;
    }
}

class BadSolution extends Solution1124 {
    public int longestWPI(int[] hours) {
        int max = 0;
        for (int i = 0; i < hours.length; i++) {
            int temp = 0;
            for (int j = i; j >= 0; j--) {
                if (hours[j] > 8) temp++;
                else temp--;
                if (temp > 0)
                    max = Math.max(max, i - j + 1);
            }
        }
        return max;
    }
}

class TestSolution extends Solution1124 {
    public int longestWPI(int[] hours) {
        int max = 0;
        for (int i = 0; i < hours.length; i++) {
            int temp = 0;
            for (int j = i; j >= 0; j--) {
                temp += hours[j] > 8 ? 1 : -1;
                if (temp > 0)
                    max = Math.max(max, i - j + 1);
            }
        }
        return max;
    }
}
