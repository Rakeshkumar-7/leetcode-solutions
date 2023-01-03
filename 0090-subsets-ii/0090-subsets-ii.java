class Solution {
    private void subsets(int[] nums, List<Integer> cur, List<List<Integer>> subsets, int i){
        subsets.add(new ArrayList<Integer>(cur));

        // pick
        for(int j=i; j<nums.length; j++){
            if(j != i && nums[j-1] == nums[j]) continue;
            cur.add(nums[j]);
            subsets(nums, cur, subsets, j+1);
            cur.remove(cur.size() - 1); // -> O(1), since its at the end of the list
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList();
        Arrays.sort(nums);
        subsets(nums, new ArrayList<Integer>(), subsets, 0);
        return subsets;
    }
}