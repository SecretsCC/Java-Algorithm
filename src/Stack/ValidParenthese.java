package Stack;

import java.util.Stack;

public class ValidParenthese {
    public static boolean isWellFormed(String s) {
        Stack<Character> leftChars = new Stack<>();
        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                leftChars.push(s.charAt(i));
            }else {
                if (leftChars.isEmpty()) {
                    return false;
                }
                if ((s.charAt(i) == ')' && leftChars.peek() != '(') || (s.charAt(i) == '}' && leftChars.peek() != '{') || (s.charAt(i) == ']' && leftChars.peek() != '[')) {
                    return false;
                }
                leftChars.pop();
            }
        }
        return leftChars.isEmpty();
    }
}
