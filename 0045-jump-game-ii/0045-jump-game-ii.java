class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int max = 0;
        int end = 0;
        for(int i=0; i<nums.length-1; i++){
            max = Math.max(max, i + nums[i]);
            // current sub-array is done
            if(i == end){
                end = max; // sub-array's window expands to max jump
                jumps++; // we make a jump to max point/end
            }
        }
        return jumps;
    }
}