class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> str1 = new Stack<>();
        Stack<Character> str2 = new Stack<>();
        int n1 = s.length(),n2 = t.length();
        for(int i = 0;i<n1;i++){
            char ch = s.charAt(i);
            if (ch == '#'){
                if (str1.size() > 0){
                    str1.pop();
                }
            } else{
                str1.push(ch);
            }
        }
        for(int i = 0;i<n2;i++){
            char ch = t.charAt(i);
            if (ch == '#'){
                if (str2.size() > 0){
                    str2.pop();
                }
            } else{
                str2.push(ch);
            }
        }
        n1 = str1.size();
        n2 = str2.size();
        if (n1!=n2){
            return false;
        } else {
            for(int i = 0;i<n1;i++){
                if (str1.pop() != str2.pop()){
                    return false;
                }
            }
            return true;
        }
    }
}