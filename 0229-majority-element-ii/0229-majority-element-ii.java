class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int x: nums){
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        
        List<Integer> majority = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry: freq.entrySet()){
            if(entry.getValue() > nums.length/3){
                majority.add(entry.getKey());
            }
        }

        return majority;
    }
}