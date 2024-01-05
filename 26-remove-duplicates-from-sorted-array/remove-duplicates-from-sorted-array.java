class Solution {
    public int removeDuplicates(int[] nums) {
        int lastAdded = 0,c = 1,n = nums.length;
        for(int i = 1;i<n;i++){
            if (checkNums(nums,i)){
                nums[++lastAdded] = nums[i];
                c+=1;
            }
        }
        return c;
    }
    public boolean checkNums(int[] nums,int j) {
        for(int i = 0;i<j;i++){
            if (nums[i] == nums[j]){
                return false;
            }
        }
        return true;
    }
}