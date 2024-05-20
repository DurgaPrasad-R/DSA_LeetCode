class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = arr.length;
        for(int i = 0;i<n;i++) {
            if (pq.size() < k) {
                pq.offer(arr[i]);
            } else{
                if(Math.abs(pq.peek()-x) > Math.abs(arr[i] - x)) {
                    pq.poll();
                    pq.offer(arr[i]);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty()) {
            res.add(pq.poll());
        }
        return res;
    }
}