class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int bp = -1;
        int n = arr.length;
        for(int i = n-2;i>=0;i--) {
            if (arr[i] > arr[i+1]) {
                bp = i;
                break;
            }
        }
        if (bp == -1) {
            return arr;
        } else {
            int swap = bp+1;
            int ele = arr[swap];
            for(int i = bp+1;i<n;i++) {
                if (arr[bp] > arr[i]) {
                    if (ele < arr[i]) {
                        swap = i;
                        ele = arr[i];
                    }
                }
            }
            int t = arr[bp];
            arr[bp] = arr[swap];
            arr[swap] = t;
            return arr;
        }
    }
}