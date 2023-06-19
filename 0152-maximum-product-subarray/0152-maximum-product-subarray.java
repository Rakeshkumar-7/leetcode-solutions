class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int localMax = 1;
        for(int i=0; i<nums.length; i++){
            localMax *= nums[i];
            max = Math.max(localMax, max);
            if(localMax == 0){
                localMax = 1;
            }
        }
        localMax = 1;
        for(int i=nums.length-1; i>=0; i--){
            localMax *= nums[i];
            max = Math.max(localMax, max);
            if(localMax == 0){
                localMax = 1;
            }
        }
        return max;
    }
}