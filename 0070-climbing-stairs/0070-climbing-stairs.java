class Solution {
    private int count(int n, int[] dp){
        if(n == 0){
            return 1;
        }else if(n < 0){
            return 0;
        }else{
            if(dp[n] == -1){
                dp[n] = count(n-1, dp) + count(n-2, dp);
            }
        }
        return dp[n];
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return count(n, dp);
    }
}