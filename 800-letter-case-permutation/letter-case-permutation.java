class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        utilFun(0,s.length(),s,"",res);
        return res;
    }

    public void utilFun(int f,int len,String s,String temp,List<String> res) {
        if (f == len) {
            res.add(temp);
            return;
        }

        else {
            if (Character.isDigit(s.charAt(f))) {
                utilFun(f+1,len,s,temp+s.charAt(f),res);
            } else {
                char ch;
                if (s.charAt(f) >= 65 && s.charAt(f) <= 90) {
                    ch = (char)(s.charAt(f) + 32);
                } else {
                    ch = (char)(s.charAt(f) - 32);
                }
                utilFun(f+1,len,s,temp+ch,res);
                utilFun(f+1,len,s,temp+s.charAt(f),res);
            }
        }
    }
}