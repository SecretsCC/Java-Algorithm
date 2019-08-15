package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber {
    Map<Character, String> phone = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return res;
        findCombinations(digits,0,"");

        return res;
    }

    private void findCombinations(String digits, int index, String s) {
        if(index == digits.length()) {
            res.add(s);
            return;
        }
        char c = digits.charAt(index);
        String letters = phone.get(c);
        for(int i = 0; i < letters.length(); ++i) {
            findCombinations(digits, index + 1, s + letters.substring(i,i+1));
        }
        return;
    }
}
