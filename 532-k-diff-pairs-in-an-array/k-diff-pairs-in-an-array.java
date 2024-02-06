class Solution {
    public int findPairs(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int c = 0;
        for(int i = 0;i<n;i++){
            int key = nums[i]+k;
            if (i>0 && nums[i] == nums[i-1]){
                continue;
            } else {
                if (bSearch(nums,i+1,n-1,key)){
                    c+=1;
                }
            }
        }
        return c;
    }
    public boolean bSearch(int[] nums,int low,int high,int x){
        while(low<=high){
            int mid = (low+high)/2;
            if (nums[mid] == x){
                return true;
            } else if (nums[mid] > x){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}