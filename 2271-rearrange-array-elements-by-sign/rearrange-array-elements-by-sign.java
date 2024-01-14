class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length,pIdx = 0,nIdx = 1;
        int[] ans = new int[n];
        for(int i = 0;i<n;i++){
            if (nums[i] > 0){
                ans[pIdx] = nums[i];
                pIdx+=2;
            } else {
                ans[nIdx] = nums[i];
                nIdx+=2;
            }
        }
        return ans;
    }
}