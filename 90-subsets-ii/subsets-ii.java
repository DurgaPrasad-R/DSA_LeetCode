class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		return findPerms(0,nums,new ArrayList<>(),result);
	}
	public static List<List<Integer>> findPerms(int idx,int[] input,List<Integer> ds,List<List<Integer>> result){
		result.add(new ArrayList<>(ds));
		for(int i = idx;i<input.length;i++){
			if (i> idx && input[i] == input[i - 1]) continue;
			ds.add(input[i]);
			findPerms(i+1,input,ds,result);
			ds.remove(ds.size() - 1);
		}
        return result;
	}
}