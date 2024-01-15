class Solution {
    public int longestConsecutive(int[] a) {
        int n = a.length;
        if (n>0){
            Arrays.sort(a);
            int smaller = a[0],len = 1, maxLength = -1;
            for(int i = 1;i<n;i++){
                if (smaller == a[i]){
                    continue;
                } else if (smaller == a[i]-1){
                    len+=1;
                    smaller = a[i];
                } else if (smaller != a[i]-1){
                    maxLength = Math.max(maxLength,len);
                    len = 1;
                    smaller = a[i];
                }
            }
            maxLength = Math.max(maxLength,len);
            return maxLength;
        } else {
            return 0;
        }
    }
}