class Solution {
    public int singleNumber(int[] nums) {
        int res = 0,n = nums.length;
        for(int i = 0;i<n;i++){
            int c = 1;
            for(int j = 0;j<n;j++){
                if (nums[i] == nums[j] && j!=i){
                    c+=1;
                }
            }
            if (c == 1){
                return nums[i];
            }
        }
        return -1;
        
    }
}