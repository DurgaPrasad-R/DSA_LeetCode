class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0,n = nums.length;
        while (i<n) {
            int correct = nums[i]-1;
            if (nums[i]>0 && nums[i]<=n && nums[i] != nums[correct]) {
                swap(nums,i,correct);
            } else {
                i++;
            }
        }
        for(i=0;i<n;i++) {
            if (nums[i]-1 != i){
                return i+1;
            }
        }
        return n+1;
    }
    public void swap(int[] nums,int f,int l) {
        int temp = nums[f];
        nums[f] = nums[l];
        nums[l] = temp;
    }
}