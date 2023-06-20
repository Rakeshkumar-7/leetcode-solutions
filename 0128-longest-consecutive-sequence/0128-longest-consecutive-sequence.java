class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int num: nums){
            heap.add(num);   
        }
        int max = 1;
        int prev = heap.poll();
        int length = 1;
        System.out.println(prev);
        while(heap.size() > 0){
            int cur = heap.poll();
            System.out.println(cur);
            if(Math.abs(cur - prev) == 1){
                length++;
            }else if(cur == prev){
                continue;
            }else{
                max = Math.max(max, length);
                length = 1;
            }
            prev = cur;
        }
        max = Math.max(max, length);
        return max;
    }
}