package String;

public class Interconvert_String_To_Integer {
    public static int StringToInteger(String s) {
        int result = 0;
        for(int i = s.charAt(0) == '-' ? 1 : 0; i < s.length(); ++i ) {
            int temp = s.charAt(i) - '0';
            result = result * 10 + temp;
        }
        return s.charAt(0) == '-' ? -result : result;
    }

    public static String IntegerToString(int x) {
        boolean isNegative = false;
        if(x < 0) {
            isNegative = true;
        }

        StringBuilder s = new StringBuilder();
        do{
            s.append((char)('0' + Math.abs(x % 10)));
            x /= 10;
        }while(x != 0);
        if(isNegative) {
            s.append('-');
        }
        s.reverse();
        return s.toString();
    }

    public static void main(String args[]) {
        String test = "123456789";
        System.out.println(StringToInteger(test));
    }
}
