class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int max = 0;
        int maxNum = 0;
        int cur = 1;
        int i;
        for(i=0; i<n-1; i++){
            if(nums[i] == nums[i+1]){
                cur++;
            }else{
                if(cur > max){
                    max = cur;
                    maxNum = nums[i];
                }
                cur = 1;
            }
        }
        if(cur > max){
            max = cur;
            maxNum = nums[i];
        }
        return maxNum;
    }
}