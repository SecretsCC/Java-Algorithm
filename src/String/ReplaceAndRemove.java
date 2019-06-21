package String;

public class ReplaceAndRemove {
    public static String replaceAndRemove(char[] s) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length; ++i) {
            if(s[i] != 'a' && s[i] != 'b') {
                res.append(s[i]);
            }else if (s[i] == 'a') {
                res.append("dd");
            }
        }
        return res.toString();
    }

    public static char[] inPlaceReplaceAndRemove(char[] s) {
        int writeIndex = 0;
        int aCount = 0;
        int size = s.length;
        for(int i = 0; i < size; ++i) {
            if(s[i] != 'b') {
                s[writeIndex++] = s[i];
            }
            if(s[i] == 'a') {
                ++aCount;
            }
        }

        int curIndex = writeIndex - 1;
        writeIndex = writeIndex + aCount - 1;
        final int finalSize = writeIndex + 1;
        while( curIndex >= 0) {
            if(s[curIndex] == 'a') {
                s[writeIndex--] = 'd';
                s[writeIndex--] = 'd';
            }else{
                s[writeIndex--] = s[curIndex];
            }
            --curIndex;
        }
        return s;
    }



    public static void main(String args[]) {
        char[] test = {'a','c','d','b','b','c','a'};
        System.out.println(replaceAndRemove(test));
        System.out.println(inPlaceReplaceAndRemove(test));
    }
}
