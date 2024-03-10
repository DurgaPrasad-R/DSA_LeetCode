class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] set = new int[1001];
        for(int i:nums1) set[i] = 1;
        int resCount = 0;
        for(int i:nums2){
            if (set[i] == 1){
                set[i] = 2;
                resCount+=1;
            }
        }
        int[] newArr = new int[resCount];
        int[] nums = nums1.length>nums2.length?nums2:nums1;
        int i = 0;
        for(int v:nums){
            if (set[v] == 2){
                newArr[i++] = v;
                set[v] = 1;
            }
        }
        return newArr;
    }
}