class Solution {
    public int findMaxLength(int[] nums) {
        int sum = 0,n = nums.length,maxLength=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            if (nums[i] == 0) {
                sum-=1;
            } else {
                sum+=1;
            }
            if (sum == 0) maxLength = i+1;
            else if(!map.containsKey(sum)){
                map.put(sum,i);
            } else {
                maxLength = Math.max(maxLength,i-map.get(sum));
            }
        }
        return maxLength;
    }
}