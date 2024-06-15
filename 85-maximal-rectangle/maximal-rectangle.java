class Pair {
    int first;
    int second;
    Pair(int f,int s) {
        first = f;
        second = s;
    }
}
class Solution {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] res = new int[n];
        int[] rIndices = findNSR(heights,n);
        int[] lIndices = findNSL(heights,n);
        for(int i = 0;i<n;i++) {
            res[i] = heights[i] * (rIndices[i] - lIndices[i] - 1);
        }
        int max = res[0];
        for(int i = 1;i<n;i++) {
            if (max < res[i]) {
                max = res[i];
            }
        }
        return max;
    }

    public static int[] findNSR(int[] heights,int n) {
        Stack<Pair> st = new Stack<>();
        int[] res = new int[n];
        for(int i = n-1;i>=0;i--) { 
            while(!st.isEmpty() && st.peek().second >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                res[i] = n;
            } else {
                res[i] = st.peek().first;
            }
            st.push(new Pair(i,heights[i]));
        }
        return res;
    }

    public static int[] findNSL(int[] heights,int n) {
        int[] res = new int[n];
        Stack<Pair> st = new Stack<>();
        for(int i = 0;i<n;i++) {
            while (!st.isEmpty() && st.peek().second >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = st.peek().first;
            }
            st.push(new Pair(i,heights[i]));
        }
        return res;
    }

    public static int[] convertInteger(char[] inp) {
        int n = inp.length;
        int[] arr = new int[n];
        for(int i = 0;i<n;i++) {
            if (inp[i] == '1') {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        return arr;
    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int cols = matrix[0].length;
        int[] initial = convertInteger(matrix[0]);
        int max = largestRectangleArea(initial);
        for(int i = 1;i<n;i++) {
            for(int j = 0;j<cols;j++) {
                if (matrix[i][j] == '0') {
                    initial[j] = 0;
                } else {
                    initial[j]+=1;
                }
            }
            max = Math.max(max,largestRectangleArea(initial));
        }
        return max;
    }
}