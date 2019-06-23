package String;

public class ReverseString2 {
    public static String reverseStr(String s, int k) {
        char[] words = s.toCharArray();
        int start = 0;
        int end = 2 * k - 1;
        while(start < words.length && (end - k) < words.length ) {
            int i = start;
            int j = end - k;
            swap(words,i,j);
            start += 2 * k;
            end += 2 * k;
        }
        if(words.length - start <= k) {
            swap(words, start, words.length - 1);
        }
        return String.valueOf(words);
    }

    private static void swap(char[] words, int start, int end) {
        while(start < end) {
            char temp = words[start];
            words[start] = words[end];
            words[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String args[]) {
        String s = "fdcqkmxwholhytmhafpesaentdvxginrjlyqzyhehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl";
        System.out.println(s.length());
        System.out.println(reverseStr(s,39));

    }


}
