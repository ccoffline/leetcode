package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.BiFunction;

public class TestLambda {

    public static void main(String[] args) {
        new TestLambda().test();
    }

    public void test() {
        String[] words = new String[500000];
        int len = 100;
        Random rand = new Random();
        String example = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        for (int i = 0; i < words.length; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < len; j++)
                builder.append(example.charAt(rand.nextInt(62)));
            words[i] = builder.toString();
        }
        System.out.println(testCommon(words));
        System.out.println(testInnerLambda(words));
        System.out.println(testVarLambda(words));
    }

    private long testCommon(String[] words) {
        Map<String, Integer> count = new HashMap<>();
        long temp = System.currentTimeMillis();

        for (String word : words)
            count.put(word, count.getOrDefault(word, 0) + 1);
        return System.currentTimeMillis() - temp;
    }

    private long testInnerLambda(String[] words) {
        Map<String, Integer> count = new HashMap<>();
        long temp = System.currentTimeMillis();
        for (String word : words)
            count.compute(word, (k, v) -> {
                if (v == null) return 1;
                return v + 1;
            });
        return System.currentTimeMillis() - temp;
    }

    private long testVarLambda(String[] words) {
        BiFunction<String, Integer, Integer> lambda = (k, v) -> {
            if (v == null) return 1;
            return v + 1;
        };
        Map<String, Integer> count = new HashMap<>();
        long temp = System.currentTimeMillis();
        for (String word : words)
            count.compute(word, lambda);
        return System.currentTimeMillis() - temp;
    }

}
