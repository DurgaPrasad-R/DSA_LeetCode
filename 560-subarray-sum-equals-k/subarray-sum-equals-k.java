import java.util.*;
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> hmap = new HashMap<>();
        int n = nums.length,cnt = 0,preSum = 0;
        hmap.put(0,1);
        for(int i = 0;i<n;i++)
        {
            preSum+=nums[i];
            if (hmap.containsKey(preSum - k)){
                cnt+=hmap.get(preSum-k);
            }
            if (hmap.containsKey(preSum)){
                hmap.put(preSum,hmap.get(preSum)+1);
            } else {
                hmap.put(preSum,1);
            }
        }
        return cnt;
    }
}