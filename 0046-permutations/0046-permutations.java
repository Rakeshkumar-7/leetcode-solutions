class Solution {
    private void permutate(int[] nums, int cur, List<List<Integer>> permutations){
        if(cur == nums.length){
            List<Integer> numsList = new ArrayList();
            for(int x: nums){
                numsList.add(x);
            }
            permutations.add(numsList);
        }
        for(int i=cur; i<nums.length; i++){
            swap(nums, cur, i);
            permutate(nums, cur + 1, permutations);
            swap(nums, cur, i);
        }
    }
    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList();
        permutate(nums, 0, permutations);
        return permutations;
    }
}