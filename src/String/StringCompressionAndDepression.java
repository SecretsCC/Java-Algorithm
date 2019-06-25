package String;

public class StringCompressionAndDepression {
    public static String decoding(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                count = count * 10 + c - '0';
            }else {
                while(count > 0) {
                    sb.append(c);
                    count--;
                }
            }
        }
        return sb.toString();
    }

    public static String encoding(String s) {
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= s.length(); ++i) {
            if(i == s.length() || s.charAt(i) != s.charAt(i - 1)) {
                sb.append(count);
                sb.append(s.charAt(i - 1));
                count = 1;
            } else {
                ++count;
            }
        }
        return sb.toString();
    }


    public static void main(String args[]) {
        String test = "3e4f2e";
        System.out.println(decoding(test));
    }
}
