class Solution {
    public int findDuplicate(int[] nums) {
        int[] seen = new int[nums.length];
        for(int x: nums){
            if(seen[x] == 1){
                return x;
            }
            seen[x] = 1;
        }
        return 1;
    }
}