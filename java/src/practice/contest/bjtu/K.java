package practice.contest.bjtu;

import java.util.*;

public class K {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
//        Scanner s = new Scanner(
//                "1\n" +
//                        "28311552 234"
//        );

        int max = 1000000000, square = (int) Math.sqrt(max), temp = 2;
        List<Integer> primes = new LinkedList<>();
        primes.add(temp++);
        while (temp <= square) {
            for (int p : primes) {
                if (temp < p * p) {
                    primes.add(temp);
                    break;
                }
                if (temp % p == 0) break;
            }
            temp += 2;
        }
        int T = s.nextInt();
        Map<Integer, Integer> count = new TreeMap<>();
        while (T-- > 0) {
            int N = s.nextInt(), M = s.nextInt();
            count.clear();
            for (int p : primes) {
                temp = 0;
                while (N % p == 0) {
                    N /= p;
                    ++temp;
                }
                if (temp > 0) count.put(p, temp);
                if (N < p) break;
            }
            max = N;
            for (Map.Entry<Integer, Integer> entry : count.entrySet())
                max = Math.max(max, count(entry.getKey(), entry.getValue()));
            System.out.println(Math.max(0, M - max + 1));
        }
    }

    private static int count(int prime, int count) {
        int left = (count + 1) / 2, right = count, log, result, temp;
        while (left < right) {
            result = log = temp = (left + right) / 2;
            while ((log /= prime) > 0) result += log;
            if (result >= count) right = temp;
            else left = temp + 1;
        }
        return left * prime;
    }
}
