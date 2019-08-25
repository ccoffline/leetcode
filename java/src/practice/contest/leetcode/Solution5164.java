package practice.contest.leetcode;

public class Solution5164 {
    public static void main(String[] args) {
        Solution5164 solution = new Solution5164();
        int[][] cases = {
                {1, 2, -3, 3, 0, 1},
                {1, -1}
        };
        for (int[] c : cases) {
            ListNode head = new ListNode(0);
            ListNode temp = head;
            for (int i : c) temp = temp.next = new ListNode(i);
            temp = solution.removeZeroSumSublists(head.next);
            while (temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode temp = head;
        head = new ListNode(0);
        head.next = temp;
        while (temp != null) {
            ListNode t = head;
            while (t != temp) {
                t.val += temp.val;
                if (t.val == 0) {
                    t.next = temp.next;
                    break;
                }
                t = t.next;
            }
            temp.val = 0;
            temp = temp.next;
        }
        if (head.next == null) return null;
        temp = head;
        while (temp != null) {
            temp.val -= temp.next.val;
            if (temp.next.val == 0) temp.next = null;
            temp = temp.next;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}