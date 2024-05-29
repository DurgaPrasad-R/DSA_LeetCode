class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        String res = "";
        int n = s.length();
        for(int i = 0;i<n;i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        Map<Integer,List<Character>> cnts = new HashMap<>();
        for(Map.Entry<Character,Integer> ele:map.entrySet()) {
            int cnt = ele.getValue();
            char ch = ele.getKey();
            if (!cnts.containsKey(cnt)) {
                cnts.put(cnt,new ArrayList<>());
            }
            cnts.get(cnt).add(ch);
        }
        // System.out.println(cnts);
        for(int i = n;i>0;i--)  {
            if (cnts.containsKey(i)) {
                // System.out.println(cnts.get(i));
                for(int k = 0;k<cnts.get(i).size();k++) {
                    for(int j = 0;j<i;j++) {
                        res+=cnts.get(i).get(k);
                    }
                }
            }
        }
        return res;
    }
}