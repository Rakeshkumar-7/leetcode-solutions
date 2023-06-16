class Solution {
    private int util(int[] nums, int[] dp, int cur){
        // at each step we can either choose to rob the current house or go to the next house
        // boundary: cur < nums.length
        if(cur >= nums.length){
            return 0;
        }
        if(dp[cur] != -1){
            return dp[cur];
        }
        
        // rob the current house
        dp[cur] = Math.max(util(nums, dp, cur + 2) + nums[cur], util(nums, dp, cur+1));
        
        return dp[cur];
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        util(nums, dp, 0);
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }
}