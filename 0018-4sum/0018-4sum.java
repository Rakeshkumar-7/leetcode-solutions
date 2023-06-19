class Solution {
    private List<List<Integer>> twoSum(int[] nums, long target, int start){
        // int[] nums will be sorted
        int left = start;
        int right = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while(right > left){
            int cur = nums[left] + nums[right];
            if(cur > target || (right + 1 < nums.length && nums[right+1] == nums[right])){
                right--;
            }else if(cur < target || (left-1 >= start && nums[left] == nums[left-1])){
                left++;
            }else{
                List<Integer> next = new ArrayList<>();
                next.add(nums[left++]);
                next.add(nums[right--]);
                res.add(next);
            }
        }
        return res;
    }
    private List<List<Integer>> kSum(int[] nums, long target, int start, int k){
        if(k == 2){
            return twoSum(nums, target, start);
        }
        List<List<Integer>> res = new ArrayList<>();
        if(start == nums.length){
            return res;
        }
        for(int i=start; i<nums.length; i++){
            if(i == start || nums[i-1] != nums[i]){
                for(List<Integer> subset: kSum(nums, target - nums[i], i+1, k-1)){
                    List<Integer> next = new ArrayList<>(Arrays.asList(nums[i]));
                    next.addAll(subset);
                    res.add(next);
                }
            }
        }
        return res;
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }
}