class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        return atMostK(nums,n,goal) - atMostK(nums,n,goal-1);
    }

    public int atMostK(int[] nums, int n,int goal) {
        if (goal < 0) {
            return 0;
        }
        int sum = 0,ans = 0,l = 0,r = 0;
        while (r < n) {
            sum+=nums[r];
            while (sum > goal) {
                sum-=nums[l];
                l++;
            }
            ans+=(r-l+1);
            r++;
        }
        return ans;
    }
}