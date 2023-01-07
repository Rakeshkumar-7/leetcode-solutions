class Solution {
    private void combinations(int[] candidates, int target, int index, List<Integer> cur, List<List<Integer>> ans){
        if(target < 0 || index >= candidates.length){
            return;
        }
        if(target == 0){
            ans.add(new ArrayList<>(cur));
        }
        for(int i=index; i<candidates.length; i++){
            if(i != index && candidates[i] == candidates[i-1]){
                continue;
            }else{
                cur.add(candidates[i]);
                combinations(candidates, target - candidates[i], i, cur, ans);
                cur.remove(cur.size() - 1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        combinations(candidates, target, 0, new ArrayList<Integer>(), ans);
        return ans;
    }
}