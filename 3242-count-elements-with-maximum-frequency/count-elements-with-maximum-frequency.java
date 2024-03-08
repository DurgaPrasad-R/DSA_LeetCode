class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> countMap = new HashMap<>();
        int max = Integer.MIN_VALUE,flag=0,ans=0;
        for(int i = 0;i<n;i++){
            if (countMap.containsKey(nums[i])) {
                flag = 1;
                countMap.put(nums[i],countMap.get(nums[i])+1);
            } else {
                countMap.put(nums[i],1);
            }
        }
        for(Map.Entry<Integer,Integer> ele:countMap.entrySet()){
            int val = ele.getValue();
            if (val > max) max=val;
        }
        for(Map.Entry<Integer,Integer> ele:countMap.entrySet()){
            if (ele.getValue() == max) ans+=max;
        }
        return ans;
    }
}