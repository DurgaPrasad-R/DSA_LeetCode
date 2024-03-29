class Solution {
    public void sortColors(int[] nums) {
        // Dutch National Flag Algo.
        int n = nums.length;
        int low = 0,high = n - 1,mid = 0;
        while(mid<=high){
            if (nums[mid] == 0){
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1){
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}