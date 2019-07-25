package Array;

public interface LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            System.out.println(s.charAt(j));
            System.out.println(index[s.charAt(j)]);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    public static void main(String args[]) {
        String s = "abcdabsedfsjlk";
        int res = lengthOfLongestSubstring(s);
    }
}
