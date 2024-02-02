class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> finalArr = new ArrayList<>();
        int n1 = nums1.length,n2 = nums2.length,new_len = n1+n2;
        int i = 0,j = 0;
        while(i<n1 && j<n2){
            if (nums1[i] < nums2[j]){
                finalArr.add(nums1[i++]);
            } else {
                finalArr.add(nums2[j++]);
            }
        }
        while(i<n1){
            finalArr.add(nums1[i++]);
        }
        while(j<n2){
            finalArr.add(nums2[j++]);
        }
        if (new_len%2 != 0){
            return (double)(finalArr.get(new_len/2));
        } else {
            return (double)((finalArr.get(new_len/2)+finalArr.get((new_len/2)-1))/2.0);
        }
    }
}