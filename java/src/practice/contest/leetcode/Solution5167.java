package practice.contest.leetcode;

import java.util.*;

public class Solution5167 {
    public static void main(String[] args) {
        Solution5167 solution = new Solution5167();
        String[][] cases = {
                {"alice,20,800,mtv", "alice,50,1200,mtv"}
        };
        for (String[] c : cases) {
            System.out.println(solution.invalidTransactions(c));
        }
    }

    public List<String> invalidTransactions(String[] transactions) {
        Set<Transaction> set = new HashSet<>();
        List<Transaction> list = new LinkedList<>();
        for (String t : transactions) list.add(new Transaction(t));
        for (Transaction a : list) {
            if (a.amount > 1000) set.add(a);
            for (Transaction b : list) {
                if (a == b) continue;
                if (Objects.equals(a.name, b.name) && !Objects.equals(a.city, b.city) && Math.abs(a.stamp - b.stamp) <= 60) {
                    set.add(a);
                    set.add(b);
                }
            }
        }
        List<String> ans = new ArrayList<>(set.size());
        for (Transaction t : set)
            ans.add(t.transactions);
        return ans;
    }
}

class Transaction {
    final String name, city, transactions;
    final int stamp, amount;

    Transaction(String transactions) {
        String[] p = transactions.split(",");
        this.name = p[0];
        this.city = p[3];
        this.stamp = Integer.parseInt(p[1]);
        this.amount = Integer.parseInt(p[2]);
        this.transactions = transactions;
    }
}