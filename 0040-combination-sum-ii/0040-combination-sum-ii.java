class Solution {
    private void combinations(int[] candidates, int target, int index, List<Integer> cur, List<List<Integer>> res){
        // target sum reached
        if(target == 0){
            res.add(new ArrayList<>(cur)); // save the cur combination
            return; // backtrack
        }
        if(target < 0 || index >= candidates.length){
            return; // backtrack
        }
        for(int i=index; i<candidates.length; i++){
            if(i != index && candidates[i] == candidates[i-1]){
                continue;
            }else{
                cur.add(candidates[i]); // modify state
                combinations(candidates, target - candidates[i], i + 1, cur, res);
                cur.remove(cur.size() - 1); // restore state
            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        combinations(candidates, target, 0, new ArrayList<Integer>(), res);
        return res;
    }
}