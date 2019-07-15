package medium;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution2 {

    private static String toString(ListNode node) {
        StringBuilder builder = new StringBuilder();
        while (node != null) {
            builder.append(node.val);
            node = node.next;
        }
        return builder.toString();
    }

    private static ListNode getNode(int[] list) {
        ListNode root = new ListNode(0), temp = root;
        for (int i : list) {
            temp = temp.next = new ListNode(i);
        }
        return root.next;
    }

    public static void main(String[] args) {
        int[][] cases = {
                {2, 4, 3},
                {5, 6, 4}
        };
        Solution2 solution = new Solution2();
        int i = 0;
        while (i < cases.length) {
            ListNode l1 = getNode(cases[i++]);
            ListNode l2 = getNode(cases[i++]);
            System.out.println(toString(solution.addTwoNumbers(l1, l2)));
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode root = new ListNode(0), temp = root;
        while (true) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (l1 != null || l2 != null || sum != 0) {
                temp = temp.next = new ListNode(sum % 10);
                sum /= 10;
            } else break;
        }
        return root.next == null ? root : root.next;
    }

}
