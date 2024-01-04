class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = -1,len = nums.length;
        int c = 0;
        for(int i = 0;i<len;i++){
            if (nums[i]!=1){
                maxCount = Math.max(maxCount,c);
                c = 0;
            } else {
                c+=1;
            }
        }
        return maxCount>c?maxCount:c;
    }
}