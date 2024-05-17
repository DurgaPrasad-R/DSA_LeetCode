class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set;
        int n = s.length(),maxLen = 0;
        for(int i = 0;i<n;i++){
            set = new HashSet<>();
            for(int j = i;j<n;j++){
                if (set.contains(s.charAt(j))) break;
                maxLen = Math.max(maxLen,j-i+1);
                set.add(s.charAt(j));
            }
        }
        return maxLen;       
    }
}