class Solution {
    public double myPow(double x, int n) {
        int temp = n;
        if (n == 0) return 1;
        if(n<0) {
            n*=-1;
        }
        double pow = getPow(x,n);
        if (temp < 0) {
            return (double)(1.0/pow);
        }
        return pow;
    }

    public double getPow(double x,int n) {
        if (n == 0) return (double)1;
        double temp = getPow(x,n/2);
        if (n % 2 == 0) {
            return (temp * temp);
        } else {
            return x*temp*temp;
        }
    }
}