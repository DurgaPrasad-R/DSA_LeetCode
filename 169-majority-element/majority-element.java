class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0,ele = 0,n = nums.length;
        for(int i = 0;i<n;i++){
            if (cnt == 0){
                cnt = 1;
                ele = nums[i];
            } else if (ele == nums[i]){
                cnt++;
            } else {
                cnt--;
            }
        }
        return ele;
    }
}