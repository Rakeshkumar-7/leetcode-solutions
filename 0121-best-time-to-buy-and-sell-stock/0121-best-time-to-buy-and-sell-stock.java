class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = Integer.MIN_VALUE;

        for(int i=1; i<prices.length; i++){
            if(max < prices[i] - min){
                max = prices[i] - min;
            }

            if(min > prices[i]){
                min = prices[i];
            }
        }

        return (max>0)?max:0;
    }
}