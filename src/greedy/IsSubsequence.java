package greedy;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if(s == null || s.length() == 0) return true;
        if(t == null || t.length() == 0) return false;

        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int sl = 0;
        int tl = 0;
        while(sl < sc.length  && tl < tc.length) {
            if(sc[sl] == tc[tl]) {
                sl++;
                tl++;
            }else {
                tl++;
            }
        }
        return sl == sc.length ? true:false;
    }
}
