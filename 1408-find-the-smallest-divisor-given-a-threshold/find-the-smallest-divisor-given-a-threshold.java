class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int mx = nums[0],n=nums.length;
        for(int i = 1;i<n;i++){
            if (nums[i] > mx){
                mx = nums[i];
            }
        }
        int low = 1,high = mx;
        while(low <= high){
            int mid = (low+high)/2;
            if (processInv(nums,mid)<=threshold){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public int processInv(int[] arr,int d){
        int n = arr.length,sum = 0;
        for(int i = 0;i<n;i++){
            sum += Math.ceil((double)arr[i]/(double)d);
        }
        return sum;
    }
}