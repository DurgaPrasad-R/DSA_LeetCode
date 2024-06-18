class Pair {
    int first,second;
    Pair(int f,int s) {
        first = f;
        second = s;
    }
}
class PairComparator implements Comparator<Pair> {
    public int compare(Pair p1,Pair p2) {
        return p1.first - p2.first;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0;i<n;i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> ele:map.entrySet()) {
            pq.add(new Pair(ele.getValue(),ele.getKey()));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[k];
        k-=1;
        while(pq.size() > 0) {
            res[k--] = pq.poll().second;
        }
        return res;
    }
}