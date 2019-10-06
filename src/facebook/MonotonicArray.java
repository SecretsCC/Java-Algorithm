package facebook;

public class MonotonicArray {
    public boolean isMonotonic(int[] A) {
        return isIncrease(A) || isDecrease(A);
    }

    private boolean isIncrease(int[] A) {
        for(int i = 1; i < A.length; ++i) {
            if(A[i - 1] > A[i]) return false;
        }
        return true;
    }

    private boolean isDecrease(int[] A) {
        for(int i = 1; i < A.length; ++i) {
            if(A[i] > A[i - 1]) return false;
        }
        return true;
    }
}
