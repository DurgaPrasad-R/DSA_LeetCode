class Solution {
    public String reverseWords(String s) {
        int n = s.length(),left = n-1;
        String temp = "",result = "";
        while(left >= 0){
            char ch = s.charAt(left);
            if (ch != ' '){
                temp=ch+temp;
            } else if (ch == ' ' && !temp.equals("")){
                if (result.equals("")){
                    result = temp;
                } else {
                    result = result + " "+temp;
                    System.out.println(temp);
                }
                temp = "";
            }
            left--;
        }
        if (!temp.equals("")){
            if (result.equals("")){
                result = temp;
            } else {
                result = result + " "+temp;
            }
        }
        return result;
    }
}