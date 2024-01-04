class Solution {
    public boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }
        int s = 0;
        int temp = x;
        while(x>0){
            int r = x%10;
            s = s*10+r;
            x = x/10;
        }
        return s == temp;
    }
}