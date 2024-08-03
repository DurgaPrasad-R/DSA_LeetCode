class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        getParans(n,n,"",res);
        return res;
    }

    public void getParans(int o,int c,String temp,List<String> res) {
        if (o == 0 && c == 0) {
            res.add(temp);
            return;
        } else {
            if (c > o) {
                if (o > 0) {
                    getParans(o-1,c,temp+"(",res);
                }
                if (c > 0) {
                    getParans(o,c-1,temp+")",res);
                }
            } else {
                if (o > 0) {
                    getParans(o-1,c,temp+"(",res);
                }
            }
        }
    }
}