class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> (a[0] == b[0])?(a[1] - b[1]):(a[0] - b[0]));
        List<int[]> _intervals = new ArrayList();
        int[] cur = intervals[0];
        for(int i=1; i<intervals.length; i++){
            if(cur[1] >= intervals[i][0]){
                cur[1] = Math.max(cur[1], intervals[i][1]);
            }else{
                _intervals.add(cur);
                cur = intervals[i];
            }
        }
        _intervals.add(cur);
        
        return _intervals.toArray(new int[_intervals.size()][]);        
    }
}