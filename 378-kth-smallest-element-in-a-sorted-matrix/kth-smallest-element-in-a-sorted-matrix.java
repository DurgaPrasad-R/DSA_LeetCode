class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b);
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                pq.add(matrix[i][j]);
            }
        }
        while(!pq.isEmpty() && k > 1) {
            // System.out.println(pq.poll());
            pq.poll();
            k--;
        }
        return pq.poll();
    }
}