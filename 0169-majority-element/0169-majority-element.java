class Solution {
    public int majorityElement(int[] nums) {
        int el = -1;
        int count = 0;
        for(int x: nums){
            if(count == 0){
                el = x;
                count = 1;
            }else if(x == el){
                count++;
            }else{
                count--;
            }
        }

        return el;
    }
}