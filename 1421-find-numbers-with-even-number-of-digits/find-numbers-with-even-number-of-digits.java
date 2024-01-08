class Solution {
    public int findNumbers(int[] nums) {
        int n = nums.length,count = 0;
        for(int i = 0;i<n;i++){
            if (countDigits(nums[i])%2 == 0){
                count+=1;    
            }
        }
        return count;
    }
    public int countDigits(int num){
        int c = 0;
        while(num>0){
            c+=1;
            num=num/10;
        }
        return c;
    }
}