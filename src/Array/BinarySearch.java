package Array;

public class BinarySearch {

    public static int BinarySearch(int[] arr, int target) {
        if (arr == null) return -1;

        int min, max, mid;
        min = 0;
        max = arr.length - 1;
        while(min < max) {
            mid = (min + max) / 2;
            if(target < arr[mid]) {
                max = mid;
            }else if(target > arr[mid]) {
                min = mid;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(BinarySearch(arr,5));
    }
}
