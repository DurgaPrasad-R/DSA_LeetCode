class Pair {
    int first,second;
    Pair(int f,int s) {
        first = f;
        second = s;
    }
}

class PairComparator implements Comparator<Pair> {
    public int compare(Pair p1,Pair p2) {
        return p2.first - p1.first;
    }
}
class Solution {
    public int calculateDis(int x1,int y1) {
        return (x1*x1+y1*y1);
    }
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());
        int n = points.length;
        for(int i = 0;i<n;i++) {
            pq.add(new Pair(calculateDis(points[i][0],points[i][1]),i));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        k-=1;
        while (!pq.isEmpty()) {
            res[k--] = points[pq.peek().second];System.out.println(pq.peek().first+" "+pq.peek().second);
            pq.poll();
        }
        return res;
    }
}