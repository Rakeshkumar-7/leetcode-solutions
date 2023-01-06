class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int max = 0;
        for(int x: costs){
            max = Math.max(max, x);
        }
        
        int[] freq = new int[max+1];
        for(int x: costs){
            freq[x]++;
        }

        int count = 0;
        for(int i=1; i<=max; i++){
            if(coins < i){
                break;
            }
            int n = Math.min(coins/i, freq[i]);
            coins -= n*i;
            count += n;
        }

        return count;
    }
}