class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n = nums1.length,m = nums2.length;
        List<Integer> res = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<m;i++){
            map.put(nums2[i],map.getOrDefault(nums2[i],0)+1);
        }
        System.out.println(map);
        for(int i = 0;i<n;i++){
            if (map.containsKey(nums1[i]) && map.get(nums1[i])>0){
                res.add(nums1[i]);
                map.put(nums1[i],map.get(nums1[i])-1);
            }
        }
        System.out.println(map);
        int len = res.size();
        int[] ar = new int[len];
        for(int i = 0;i<len;i++){
            ar[i] = res.get(i);
        }
        return ar;
    }
}