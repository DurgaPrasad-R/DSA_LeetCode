class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        return getMostK(nums,n,k) - getMostK(nums,n,k-1);
    }

    public int getMostK(int[] nums, int n, int k) {
        if (k < 0) {
            return 0;
        }
        int l = 0,r = 0,cnt = 0,ans = 0;
        while (r < n) {
            cnt+=(nums[r]%2);
            while (cnt > k) {
                cnt-=(nums[l]%2);
                l++;
            }
            ans+=(r-l+1);
            r++;
        }
        return ans;
    }
}