class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int max = 0;
        int i=0;
        int j=0;
        while(j < n){
            if(map.containsKey(s.charAt(j))){
                int prev = map.get(s.charAt(j));
                while(i <= prev){
                    map.remove(s.charAt(i));
                    i++;
                }
            }
            map.put(s.charAt(j), j);
            max = Math.max(j-i+1, max);
            j++;
        }
        return max;
    }
}