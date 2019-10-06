package facebook;

public class VersionControl {
    public boolean isBadVersion(int a){
        return true;
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left < right) {
            int mid = (right - left) / 2 + left;
            if(isBadVersion(mid)) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
}
