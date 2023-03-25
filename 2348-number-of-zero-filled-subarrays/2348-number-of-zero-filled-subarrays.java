class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        long sub = 0;

        for(int num: nums){
            if(num == 0){
                sub++;
            }else{
                sub = 0;
            }
            count += sub;
        }

        return count;
    }
}