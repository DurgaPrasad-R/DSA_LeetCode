class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> stk = new Stack<>();
        String res = "";
        int len = s.length();
        for(int i = 0;i<len;i++)
        {
            if (s.charAt(i) == '(')
            {
                if (stk.size() > 0) {
                    res+='(';
                }
                stk.push('(');
            } else {
                if (stk.peek() == '('){
                    stk.pop();
                }
                if (stk.size() > 0) {
                    res+=')';
                }
            }
        }
        return res;
    }
}