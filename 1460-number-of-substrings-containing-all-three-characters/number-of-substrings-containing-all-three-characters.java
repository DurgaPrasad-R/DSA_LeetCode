class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int n = s.length();
        int c = 0;
        for(int i = 0;i<n;i++) {
            map.put(s.charAt(i),i);
            if (map.containsKey('a') && map.containsKey('b') && map.containsKey('c')) {
                c+=1+Math.min(map.get('a'),Math.min(map.get('b'),map.get('c')));
            }
        }
        return c;
    }
}