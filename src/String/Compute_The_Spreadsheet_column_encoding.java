package String;

public class Compute_The_Spreadsheet_column_encoding {
    public static int Convert(String s) {
        int result = 0;
        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            result = result * 26 + c - 'A' + 1;
        }
        return result;
    }

    public static void main(String args[]) {
        System.out.println(Convert("ZZ"));
    }
}
