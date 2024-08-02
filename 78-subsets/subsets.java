class Solution {
    public List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        recursivePrint(0,arr,new ArrayList<>(), arr.length, result);
        return(result);
    }
    public static void recursivePrint(int idx, int[] arr,List<Integer> ds, int len,List<List<Integer>> result){
        if (idx == len){
            result.add(new ArrayList<>(ds));
            return;
        } else {
            ds.add(arr[idx]);
            recursivePrint(idx+1,arr,ds,len,result);
            ds.remove(ds.indexOf(arr[idx]));
            recursivePrint(idx+1,arr,ds,len,result);
        }
    }
}