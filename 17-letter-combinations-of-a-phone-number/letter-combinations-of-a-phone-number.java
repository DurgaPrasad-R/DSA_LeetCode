class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        solve(digits,res,0,"");
        return res;
    }
    public String alphaS(char x){
        if (x == '2') return "abc";
        else if (x == '3') return "def";
        else if (x == '4') return "ghi";
        else if (x == '5') return "jkl";
        else if (x == '6') return "mno";
        else if (x == '7') return "pqrs";
        else if (x == '8') return "tuv";
        else if (x == '9') return "wxyz";
        return "";
    }
    public void solve(String digits,List<String> result,int idx,String ans){
        if (idx == digits.length()) {
            result.add(ans);
            return;
        }
        String temp = alphaS(digits.charAt(idx));
        for(int i = 0;i<temp.length();i++){
            solve(digits,result,idx+1,ans+temp.charAt(i));
        }
    }
}