class Solution {
    public String customSortString(String order, String s) {
        Map<Character,Integer> charMap = new HashMap<>();
        String result = "";
        int m = order.length(),n = s.length();
        for(int i = 0;i<n;i++){
            char ch = s.charAt(i);
            charMap.put(ch,charMap.getOrDefault(ch,0)+1);
        }
        for(int i = 0;i<m;i++){
            char ch = order.charAt(i);
            if (charMap.containsKey(ch)){
                int val = charMap.get(ch);
                for(int j = 0;j<val;j++){
                    result+=ch;
                }
                charMap.remove(ch);
            }
        }
        Iterator<Map.Entry<Character,Integer>> iterator = charMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Character,Integer> entry = iterator.next();
            char ch = entry.getKey();
            int val = entry.getValue();
            for(int j = 0;j<val;j++){
                result+=ch;
            }
            iterator.remove();
        }
        return result;
    }
}