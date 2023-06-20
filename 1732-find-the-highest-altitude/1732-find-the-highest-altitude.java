class Solution {
    public int largestAltitude(int[] gain) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int x: gain){
            max = Math.max(sum, max);
            sum += x;
        }
        max = Math.max(sum, max);
        return max;
    }
}