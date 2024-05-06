class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<n;i++) {
            set.add(nums[i]);
        }
        int maxCnt = 0;
        for(int i = 0;i<n;i++){
            if (set.contains(nums[i]-1)){
                continue;
            } else {
                int cnt = 1;
                int x = nums[i]+1;
                while(set.contains(x)){
                    cnt+=1;
                    x+=1;
                }
                maxCnt = Math.max(cnt,maxCnt);
            }
        }
        return maxCnt;
    }
}