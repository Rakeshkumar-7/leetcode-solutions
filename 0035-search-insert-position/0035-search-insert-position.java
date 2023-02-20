class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int mid;
        int index = -1;
        while(l <= r){
            mid = (r - l)/2 + l;
            if(nums[mid] == target){
                index = mid;
                break;
            }else if(nums[mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        // System.out.println("L: " + l + ", " + "R: " + r + ", index: " + index);
        // not found
        if(index == -1){
            if(l >= nums.length){
                index = nums.length;
            }else if(target <= nums[l]){
                index = l;
            }else{
                index = r;
            }
        }

        return index;
    }
}