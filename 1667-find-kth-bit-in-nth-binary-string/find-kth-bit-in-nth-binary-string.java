class Solution {
    private Map<Integer, String> memo = new HashMap<>();  // Memoization map

    public char findKthBit(int n, int k) {
        String result = findString(n);
        return result.charAt(k - 1);
    }

    public String findString(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        if (n == 1) {
            return "0";
        }

        String temp = findString(n - 1);
        String result = temp + "1" + reverse(invert(temp));

        memo.put(n, result);
        return result;
    }

    public String invert(String s) {
        int n = s.length();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                temp.append('1');
            } else {
                temp.append('0');
            }
        }
        return temp.toString();
    }

    public String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
