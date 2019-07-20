package hard;

import java.util.*;

public class Solution1096 {

    public static void main(String[] args) {
        String[] cases = {
                "{a,b}{c{d,e}}",
                "{a,b}c{d,e}f",
                "{{a,z},a{b,c},{ab,z}}",
                "{a{b,c}}{{d,e}f{g,h}}",
                "{a,{a,{x,ia,o},w}er{n,{g{u,o}},{a,{x,ia,o},w}},er}",
                "{a,{b,{x,ia,o},w}er{n,{g{u,o}},{a,{x,ia,o},w}},er}",
        };
        String[][] results = {
                {"acd", "ace", "bcd", "bce"},
                {"acdf", "acef", "bcdf", "bcef"},
                {"a", "ab", "ac", "z"},
                {"abdfg", "abdfh", "abefg", "abefh", "acdfg", "acdfh", "acefg", "acefh"},
                {"a", "aera", "aergo", "aergu", "aeria", "aern", "aero", "aerw", "aerx", "er", "iaera", "iaergo", "iaergu", "iaeria", "iaern", "iaero", "iaerw", "iaerx", "oera", "oergo", "oergu", "oeria", "oern", "oero", "oerw", "oerx", "wera", "wergo", "wergu", "weria", "wern", "wero", "werw", "werx", "xera", "xergo", "xergu", "xeria", "xern", "xero", "xerw", "xerx"},
                {"a", "bera", "bergo", "bergu", "beria", "bern", "bero", "berw", "berx", "er", "iaera", "iaergo", "iaergu", "iaeria", "iaern", "iaero", "iaerw", "iaerx", "oera", "oergo", "oergu", "oeria", "oern", "oero", "oerw", "oerx", "wera", "wergo", "wergu", "weria", "wern", "wero", "werw", "werx", "xera", "xergo", "xergu", "xeria", "xern", "xero", "xerw", "xerx"},
        };
        Solution1096 solution = new Solution1096();
        for (int i = 0; i < cases.length; ++i) {
            List<String> result = solution.braceExpansionII(cases[i]);
            System.out.println(result);
            System.out.println(Arrays.toString(results[i]));
            System.out.println();
        }
    }

    public List<String> braceExpansionII(String expression) {
        chars = expression.toCharArray();
        index = 0;
        return new ArrayList<>(parse());
    }

    private int index;
    private char[] chars;

    private char getNext() {
        return chars[index++];
    }

    private boolean hasNext() {
        return index < chars.length;
    }

    private String substring(int start, int end) {
        return String.valueOf(chars, start, end - start);
    }

    private Collection<String> parse() {
        Collection<String> result = new TreeSet<>(), temp = new TreeSet<>();
        int pre = index;
        while (hasNext()) {
            switch (getNext()) {
                case ',':
                    temp = cross(temp, substring(pre, index - 1));
                    result.addAll(temp);
                    temp = new TreeSet<>();
                    pre = index;
                    break;
                case '{':
                    temp = cross(temp, substring(pre, index - 1));
                    temp = cross(temp, parse());
                    pre = index;
                    break;
                case '}':
                    temp = cross(temp, substring(pre, index - 1));
                    result.addAll(temp);
                    return result;
            }
        }
        temp = cross(temp, substring(pre, index));
        result.addAll(temp);
        return result;
    }

    private Collection<String> cross(Collection<String> x, Collection<String> y) {
        SortedSet<String> result = new TreeSet<>();
        if (x.isEmpty()) result.addAll(y);
        for (String a : x)
            for (String b : y)
                result.add(a + b);
        return result;
    }

    private Collection<String> cross(Collection<String> x, String b) {
        SortedSet<String> result = new TreeSet<>();
        if (x.isEmpty()) result.add(b);
        for (String a : x)
            result.add(a + b);
        return result;
    }
}
