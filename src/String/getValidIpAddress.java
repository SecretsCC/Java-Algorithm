package String;

import java.util.ArrayList;
import java.util.List;

public class getValidIpAddress {
    public static List<String> getValidIpAddress(String s) {
        List<String> result = new ArrayList<>();
        for(int i = 1; i < 4 && i < s.length(); ++i) {
            final String first = s.substring(0,i);
            if(isValidPart(first)) {
                for(int j = 1; i + j < 4 && j < s.length(); ++j) {
                    final String second = s.substring(i, i + j);
                    if(isValidPart(second)) {
                        for(int k = 1; i + k + j < s.length() && k < 4; ++k) {
                            final String third = s.substring(i + j, i + j + k);
                            final String fourth = s.substring(i + j + k);
                            if(isValidPart(third) && isValidPart(fourth)) {
                                result.add(first + "." + second + "." + third + "." + fourth);
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    private static boolean isValidPart(String s) {
        if(s.length() > 3) {
            return false;
        }

        if(s.startsWith("0") && s.length() > 1) {
            return false;
        }
        int val = Integer.parseInt(s);
        return val <= 255 && val >= 0;
    }


    public static void main(String args[]) {

    }
}
