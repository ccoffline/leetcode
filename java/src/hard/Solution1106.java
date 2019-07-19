package hard;

import java.util.LinkedList;

public class Solution1106 {

    public static void main(String[] args) {
        String[] cases = {
                "t", // t
                "!(f)", // t
                "|(f,t)", // t
                "&(t,f)", // f
                "&(t,t,t)", // t
                "&(t,f,t)", // f
                "|(&(t,f,t),!(t))", // f
                "!(&(!(t),&(f),|(f)))", // t
                "&(&(&(!(&(f)),&(t),|(f,f,t)),|(t),|(f,f,t)),!(&(|(f,f,t),&(&(f),&(!(t),&(f),|(f)),&(!(&(f)),&(t),|(f,f,t))),&(t))),&(!(&(&(!(&(f)),&(t),|(f,f,t)),|(t),|(f,f,t))),!(&(&(&(t,t,f),|(f,f,t),|(f)),!(&(t)),!(&(|(f,f,t),&(&(f),&(!(t),&(f),|(f)),&(!(&(f)),&(t),|(f,f,t))),&(t))))),!(&(f))))"
                // f
        };
        Solution1106 solution = new Solution1106();
        for (String s : cases)
            System.out.println(solution.parseBoolExpr(s));
    }

    public boolean parseBoolExpr(String expression) {
        LinkedList<Character> sign = new LinkedList<>();
        LinkedList<Boolean> bool = new LinkedList<>();
        Boolean result = null, temp;
        for (char c : expression.toCharArray()) {
            switch (c) {
                case 't':
                    if (sign.isEmpty()) return true;
                    if (sign.getLast() != '&' || result == null)
                        result = true;
                    break;
                case 'f':
                    if (sign.isEmpty()) return false;
                    if (sign.getLast() != '|' || result == null)
                        result = false;
                    break;
                case '!':
                case '&':
                case '|':
                    bool.addLast(result);
                    sign.addLast(c);
                    result = null;
                    break;
                case ')':
                    temp = bool.removeLast();
                    if (sign.removeLast() == '!')
                        result = !result;
                    if (sign.isEmpty()) return result;
                    switch (sign.getLast()) {
                        case '|':
                            if (temp != null) result |= temp;
                            break;
                        case '&':
                            if (temp != null) result &= temp;
                            break;
                    }
            }
        }
        return result;
    }
}
