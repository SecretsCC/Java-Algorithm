package Array;


/**
 *
 * 1 2 3 4 5 6 7
 * 4 5 6 7 1 2 3
 */


public class SearchInSortArray {
    public static int SearchInSortArray(int[] arr, int target){
        if(arr.length == 0 || arr == null) return -1;
        int start = 0;
        int end = arr.length - 1;
        while((start + 1) < end ) {
            int mid = start + (end - start) / 2;
            if(target == arr[mid]) return mid;
            if(arr[start] < arr[mid]) {
                if(arr[start] <= target && target <= arr[mid]) {
                    end = mid;
                }else start = mid;
            }else {
                if(arr[mid] <= target && target <= arr[end]) {
                    start = mid;
                }else end = mid;
            }
        }
        if(arr[start] == target ) return start;
        if(arr[end] == target ) return end;
        return -1;
    }

    public static void main(String args[]) {
        int[] arr = {4,5,6,7,1,2,3};
        System.out.print(SearchInSortArray(arr,2));
    }
}
