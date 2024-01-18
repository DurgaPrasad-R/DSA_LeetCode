class Solution {
    public List<Integer> majorityElement(int[] v) {
        List<Integer> res = new ArrayList<>();
        int n = v.length,cnt1 = 0,cnt2 = 0,ele1 = Integer.MIN_VALUE,ele2 = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            if (cnt1 == 0 && v[i]!=ele2){
                cnt1 = 1;
                ele1 = v[i];
            } else if (cnt2 == 0 && v[i]!=ele1){
                cnt2 = 1;
                ele2 = v[i];
            } else if (v[i] == ele1){
                cnt1++;
            } else if (v[i] == ele2){
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }
//        System.out.println(ele1+" "+ele2);
        int mini = (n/3);
        cnt1 = 0;cnt2 = 0;
        for(int i = 0;i<n;i++){
            if (v[i] == ele1){
                cnt1++;
            }
            if (v[i] == ele2){
                cnt2++;
            }
        }
        if (cnt1>mini){
            res.add(ele1);
        }
        if (cnt2>mini){
            res.add(ele2);
        }
        Collections.sort(res);
        return res;
    }
}