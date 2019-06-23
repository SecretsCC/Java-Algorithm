package String;

public class ReverseWordsInString {
    public static String reverseWordsInString(String s) {
        String[] words = s.trim().split("\\s+");

        StringBuilder sb = new StringBuilder();

        for(int i = words.length - 1; i >= 0; --i) {
            sb.append(words[i]);
            if(i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        String test = "   a good    example   ";
        String res = reverseWordsInString(test);
        System.out.println(res);

        char[] words = {'a','b','c','d'};

        for(int i = 0; i < words.length / 2; ++i) {
            char temp = words[i];
            words[i] = words[words.length - 1 - i];
            words[words.length - 1 - i] = temp;
        }
        System.out.println(words);
    }
}
