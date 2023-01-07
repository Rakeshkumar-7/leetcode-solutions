class Solution {
    private void combinations(int n, int k, int cur, List<Integer> combination, List<List<Integer>> res){
        if(combination.size() == k){
            res.add(new ArrayList<>(combination));
            return;
        }
        if(cur > n){
            return;
        }
        for(int i=cur; i<=n; i++){
            combination.add(i);
            combinations(n, k, i+1, combination, res);
            combination.remove(combination.size() - 1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combinations(n, k, 1, new ArrayList<>(), res);
        return res;
    }
}