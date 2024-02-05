class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n1 = nums1.length,n2 = nums2.length;
        if (n1>n2){
            return intersection(nums2,nums1);
        } else {
            Set<Integer> firstSet = new HashSet<>();
            Set<Integer> commonSet = new HashSet<>();
            List<Integer> resEle = new ArrayList<>();
            for(int i = 0;i<n2;i++){
                firstSet.add(nums2[i]);
            }
            for(int i = 0;i<n1;i++){
                if (commonSet.contains(nums1[i])){
                    continue;
                } else {
                    if (firstSet.contains(nums1[i])){
                        commonSet.add(nums1[i]);
                        resEle.add(nums1[i]);
                    }
                }
            }
            int resCnt = resEle.size();
            int[] resArr = new int[resCnt];
            for(int i = 0;i<resCnt;i++){
                resArr[i] = resEle.get(i);
            }
            return resArr;
        }
    }
}