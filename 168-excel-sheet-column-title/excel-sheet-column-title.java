class Solution {
    public String convertToTitle(int columnNumber) {
        String res = "";
        while (columnNumber > 0) {
            columnNumber--;
            int rem = columnNumber % 26;
            res = (char)('A'+rem) + res;
            columnNumber = columnNumber / 26;
        }
        return res;
    }
}