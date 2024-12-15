class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0] + a[1], b[0] + b[1]) // Sort pairs based on sum
        );

        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }
        
        while (!pq.isEmpty() && res.size() < k) {
            int[] curr = pq.poll();
            int num1 = curr[0];
            int num2 = curr[1];
            int idx2 = curr[2];
            res.add(Arrays.asList(num1, num2));
            if (idx2 + 1 < nums2.length) {
                pq.offer(new int[]{num1, nums2[idx2 + 1], idx2 + 1});
            }
        }
        return res;
    }
}