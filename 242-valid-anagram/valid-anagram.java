class Solution {
    public boolean isAnagram(String s, String t) {
        Set<Character> set = new HashSet<>();
        int n = s.length(),m = t.length();
        for(int i = 0;i<n;i++){
            set.add(s.charAt(i));
        }
        for(int i = 0;i<m;i++){
            if (!set.contains(t.charAt(i))){
                return false;
            }
        }
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        // System.out.println(map);
        for(int i = 0;i<m;i++){
            map.put(t.charAt(i),map.get(t.charAt(i))-1);
        }
        // System.out.println(map);
        for(Map.Entry<Character,Integer> ele:map.entrySet()){
            if (ele.getValue() != 0) return false;
        }
        return true;
    }
}