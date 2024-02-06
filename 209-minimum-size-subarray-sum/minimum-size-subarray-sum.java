class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length,min = Integer.MAX_VALUE,preSum = 0;
        int start = 0,end = 0,flag = -1;
        for(int i = 0;i<n;i++){
            preSum+=nums[end++];
            while(preSum>=target){
                flag = 1;
                min = Math.min(min,end-start);
                preSum-=nums[start++];
            }
        }
        if (flag == -1){
            return 0;
        }
        return min;
    }
}