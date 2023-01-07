class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += gas[i] - cost[i];
        }
        if(sum < 0){
            return -1;
        }
        int start = 0;
        int cur = 0;
        for(int i=0; i<gas.length; i++){
            cur += gas[i] - cost[i];
            if(cur < 0){
                start = i+1;
                cur = 0;
            }
        }
        return start;
    }
}