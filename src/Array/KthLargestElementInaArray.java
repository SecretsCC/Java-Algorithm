package Array;

import java.util.Random;

public class KthLargestElementInaArray {
    int[] nums;

    public void swap(int a, int b) {
        int tmp = this.nums[a];
        this.nums[a] = this.nums[b];
        this.nums[b] = tmp;
    }

    public int partition(int left, int right, int pivotIndex) {
        int pivot = this.nums[pivotIndex];
        swap(pivotIndex, right);
        int storeIndex = left;

        for(int i = left; i <= right; ++i) {
            if(this.nums[i] < pivot) {
                swap(storeIndex,i);
                storeIndex++;
            }
        }

        swap(storeIndex,right);
        return storeIndex;
    }

    public int quickSelect(int left, int right, int k_index ) {
        if(left == right)
            return nums[left];

        Random random_num = new Random();
        int pivotIndex = left + random_num.nextInt(right - left);

        pivotIndex = partition(left, right, pivotIndex);

        if(pivotIndex == k_index) {
            return this.nums[k_index];
        }else if (k_index < pivotIndex) {
            return quickSelect(left,pivotIndex,k_index);
        }
        return quickSelect(pivotIndex,right,k_index);



    }

    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;

        return quickSelect(0, nums.length - 1, nums.length - k);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,7,5,3,6,8,4,3,2,6};
        KthLargestElementInaArray a = new KthLargestElementInaArray();
        int kth = a.findKthLargest(arr,2);
        System.out.print("Kth largest number is: " + kth);
    }
}
