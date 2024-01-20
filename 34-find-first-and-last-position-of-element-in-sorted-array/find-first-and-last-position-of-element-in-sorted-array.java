class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0,end = nums.length-1;
        int left = bSearch(nums,start,end,target,true);
        int right = bSearch(nums,start,end,target,false);
        if (left == -1 || right == -1){
            return new int[] {-1,-1}; 
        } else {
            return new int[] {left,right};
        }
    }
    public int bSearch(int[] nums,int start,int end,int target,boolean startIdx)
    {
        int ans = -1;
        while(start<=end){
            int mid = (start+end)/2;
            if (nums[mid] == target){
                ans = mid;
                if (startIdx){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (nums[mid] > target){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}