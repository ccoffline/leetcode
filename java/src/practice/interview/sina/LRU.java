package practice.interview.sina;

import java.util.HashMap;
import java.util.Map;

public class LRU {

    private Map<Integer, Node> m;
    private Node head, tail;
    private int c, size;

    public LRU(int capacity) {
        c = capacity;
        m = new HashMap<>(c * 4 / 3);
    }

    public int get(int key) {
        Node n = m.get(key);
        if (n == null) return -1;
        if (n != tail) {
            n.next.prev = n.prev;
            if (n == head) {
                head = n.next;
            } else {
                n.prev.next = n.next;
            }
            n.prev = tail;
            n.next = null;
            tail = tail.next = n;
        }
        return n.value;
    }

    public void put(int key, int value) {
        Node n = m.get(key);
        if (n != null) return;
        n = new Node(key, value);
        m.put(key, n);
        if (size < c) {
            if (size == 0) head = tail = n;
            else {
                n.prev = tail;
                tail = tail.next = n;
            }
            size++;
        } else {
            m.remove(head.key);
            head = head.next;
            head.prev = null;
            n.prev = tail;
            tail = tail.next = n;
        }
    }

    private static class Node {
        int key, value;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }
}