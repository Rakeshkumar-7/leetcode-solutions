class Solution {
    private Boolean canDo(int[] weights, int days, int capacity){
        int _capacity = 0;
        int _days = 0;
        for(int i=0; i<weights.length; i++){
            if(_capacity + weights[i] <= capacity){
                _capacity += weights[i];
            }else{
                _capacity = weights[i];
                _days++;
            }
        }
        if(_capacity <= capacity){
            _days++;
        }
        return _days <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int start = Integer.MIN_VALUE;
        int end = 0;
        for(int weight: weights){
            start = Math.max(start, weight);
            end += weight;
        }
        int mid;
        while(start <= end){
            mid = (end - start)/2 + start;
            if(canDo(weights, days, mid)){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }
}