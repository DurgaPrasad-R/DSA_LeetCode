class Solution {
    public String minRemoveToMakeValid(String s) {
        int n = s.length(),c=0;
        char[] chars = s.toCharArray();
        for(int i = 0;i<n;i++){
            if (chars[i] == '(') c+=1;
            else if (chars[i] == ')') {
                if (c == 0) chars[i] = '*';
                else c-=1;
            }
        }
        for(int i = n-1;i>=0;i--){
            if (c > 0 && chars[i] == '(') {
                chars[i] = '*';
                c-=1;
            }
        }
        String res = "";
        int idx = 0;
        for(int i = 0;i<n;i++) if (chars[i] !='*') chars[idx++] = chars[i];
        res = new String(chars).substring(0,idx);
        return res;
    }
}