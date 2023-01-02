class Solution {
    private void createSubsets(int[] nums, Set<List<Integer>> subsets, List<Integer> curSub, int cur){
        // We can include the cur element or skip it
        subsets.add(new ArrayList<Integer>(curSub));
        if(cur >= nums.length){
            return;
        }
        createSubsets(nums, subsets, new ArrayList<Integer>(curSub), cur+1);
        curSub.add(nums[cur]);
        createSubsets(nums, subsets, new ArrayList<Integer>(curSub), cur+1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> subsets = new HashSet<>();
        createSubsets(nums, subsets, new ArrayList<Integer>(), 0);
        return new ArrayList<>(subsets);
    }
}