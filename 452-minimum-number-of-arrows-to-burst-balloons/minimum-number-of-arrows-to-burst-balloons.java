class Comp implements Comparator<int[]>{
    public int compare(int[] a,int[] b){
        return a[0] - b[0];
    }
}
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)-> Integer.compare(a[1],b[1]));
        int n = points.length;
        int arrows = 1;
        int end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            int[] balloon = points[i];
            if (balloon[0] > end) { 
                arrows++;
                end = balloon[1]; 
            }
        }

        return arrows;
    }
}