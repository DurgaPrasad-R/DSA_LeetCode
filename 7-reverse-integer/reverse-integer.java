class Solution {
    public int reverse(int x) {
        int flag = -1,s = 0;
        int maxDiv10 = Integer.MAX_VALUE / 10;
        int minDiv10 = Integer.MIN_VALUE / 10;
        while(x!=0){
            int r = x%10;
            x = x/10;
            if (s > maxDiv10 || (s == maxDiv10 && r > 7) ){
                return 0;
            }
            if (s < minDiv10 || (s == minDiv10 && r < -8)){
                return 0;
            }
            s = s*10+r;
        }
        return s;
    }
}