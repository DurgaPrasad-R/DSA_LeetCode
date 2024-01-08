class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length-1,n = nums.length;
        int[] result = new int[n];
        for(int i = n-1;i>=0;i--){
            if (Math.abs(nums[left]) > Math.abs(nums[right])){
                result[i] = nums[left]*nums[left];
                left++;
            } else {
                result[i] = nums[right]*nums[right];
                right--;
            }
        }
        for(int i = 0;i<n;i++){
            nums[i] = result[i];
        }
        return nums;
    }
}