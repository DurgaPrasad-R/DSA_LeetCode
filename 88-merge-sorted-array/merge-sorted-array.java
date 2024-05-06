class Solution {
    public void merge(int[] a, int n, int[] b, int m) {
        List<Integer> res = new ArrayList<>();
        int i = 0,j = 0;
        while(i<n && j<m){
            if (a[i] > b[j]){
                res.add(b[j]);
                j++;
            } else {
                res.add(a[i]);
                i++;
            }
        }
        while(i<n){
            res.add(a[i]);
            i++;
        }
        while(j<m){
            res.add(b[j]);
            j++;
        }
        for(i = 0;i<n+m;i++){
            a[i] = res.get(i);
        }
    }
}