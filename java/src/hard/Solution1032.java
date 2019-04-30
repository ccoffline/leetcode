package hard;

import java.util.*;

public class Solution1032 {
    public static void main(String[] args) {
        String[] param = {"cd", "f", "kl"};
        char[] cases = {'b', 'c', 'd', 'e', 'f', 'h', 'i', 'k', 'k', 'l', 'm',};
        StreamChecker checker = new StreamCheckerV1(param);
//        StreamChecker checker = new StreamCheckerV2(param);
        for (char c : cases)
            System.out.println(checker.query(c));
    }
}

abstract class StreamChecker {
    public abstract boolean query(char letter);
}

class StreamCheckerV1 extends StreamChecker {

    public StreamCheckerV1(String[] words) {
        dictionary = new Node();
        for (String word : words) {
            Node temp = dictionary;
            for (char c : word.toCharArray())
                temp = temp.next.computeIfAbsent(c, k -> new Node());
            temp.end = true;
        }
        expect = new LinkedList<>();
    }

    private Node dictionary;
    private LinkedList<Node> expect;

    public boolean query(char letter) {
        expect.add(dictionary);
        boolean result = false;
        int size = expect.size();
        for (int i = 0; i < size; i++) {
            Node node = expect.remove();
            if ((node = node.next.get(letter)) != null) {
                result |= node.end;
                expect.add(node);
            }
        }
        return result;
    }

    private static class Node {
        boolean end = false;
        Map<Character, Node> next = new HashMap<>();
    }
}

class StreamCheckerV2 extends StreamChecker {

    public StreamCheckerV2(String[] words) {
        dictionary = new Node();
    }

    public boolean query(char letter) {
        return false;
    }

    private Node dictionary;

    private static class Node {
        boolean start = false;
        Map<Character, Node> next = new HashMap<>();
    }
}