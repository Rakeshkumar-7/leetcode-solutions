class Solution {
    public int findDuplicate(int[] nums) {

        int low = 1;
        int high = nums.length - 1;
        int duplicate = -1;
        while(low <= high){
            int mid = (low + high)/2;
            int count = 0;
            for(int i=0; i<nums.length; i++){
                if(nums[i] <= mid){
                    count++;
                }
            }

            if(count > mid){
                duplicate = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return duplicate;
    }
}