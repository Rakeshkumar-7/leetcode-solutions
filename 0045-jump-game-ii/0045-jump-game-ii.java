class Solution {
    private int solve(int[] nums, int i, int[] dp){
        if(i >= nums.length-1){
            return 0;
        }
        if(dp[i] != 1000001){
            return dp[i];
        }
        for(int j=1; j<=nums[i]; j++){
            dp[i] = Math.min(dp[i], 1 + solve(nums, i + j, dp));
        }
        return dp[i];
    }
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1000001);
        dp[nums.length-1] = 0;
        solve(nums, 0, dp);
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }
}