package String;

import java.awt.*;

public class isPalindrom {
    public static boolean isPalindrom(String s) {
        if(s == null || s.length() == 0) return false;
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            while(!Character.isLetterOrDigit(s.charAt(i)) && i < j) {
                ++i;
            }
            while(!Character.isLetterOrDigit(s.charAt(j)) && i < j) {
                --j;
            }
            if(Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        String test = "abcdcba";
        String test2 = "Able was I, ere I saw Elba!";
        System.out.println(isPalindrom(test2));
        System.out.println(isPalindrom(test));
    }
}
