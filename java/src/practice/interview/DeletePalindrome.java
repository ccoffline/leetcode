package practice.interview;

/**
 * 微软：
 * 给定一个字符串，每次删除一个回文串或字符，最少几次能删干净
 */
public class DeletePalindrome {

    public static void main(String[] args) {
        DeletePalindrome s = new DeletePalindrome();
        String[] cases = {
                "0",
                "11",
                "23",
                "123123",
                "321455412312321",
                "9876543210123456789876543210123456789",
                "718569827967081972318691789738590128976347258621873101937910371968879210386971368261971289637519"
        };
        for (String c : cases)
            System.out.println(s.deletionCount(c));
    }

    public int deletionCount(String s) {
        State state = new State(s.length());
        for (int j = 0; j < s.length(); j++) state.set(j, j, 1);
        for (int i = 0, j = 1; j < s.length(); j++, i++) state.set(i, j, s.charAt(i) == s.charAt(j) ? 1 : 2);
        for (int r = 2; r < s.length(); r++) {
            for (int i = 0, j = r; j < s.length(); j++, i++) {
                if (s.charAt(i) == s.charAt(j)) state.set(i, j, state.get(i + 1, j - 1));
                else {
                    int temp = Integer.MAX_VALUE;
                    for (int m = i + 1; m < j; m++)
                        temp = Math.min(temp, state.get(i, m - 1) + state.get(m, j));
                    state.set(i, j, temp);
                }
            }
        }
        return state.get(0, s.length() - 1);
    }

    static class State {

        private int len;
        private int[] state;

        State(int len) {
            this.len = len * 2;
            state = new int[len * (len + 1) / 2];
        }

        int get(int i, int j) {
            return state[(len - i - 1) * i / 2 + j];
        }

        void set(int i, int j, int v) {
            state[(len - i - 1) * i / 2 + j] = v;
        }
    }
}
