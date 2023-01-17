class Solution {
    public int minFlipsMonoIncr(String s) {
        int ones = 0; // number of ones including the first appearance
        int flips = 0; // number of bits to flip after the first one, if any

        for(int i=0; i<s.length(); i++){
            if(ones == 0 && s.charAt(i) == '1'){
                ones++;
            }else{ // encountered first one, executes from next bit
                if(s.charAt(i) == '1'){
                    ones++;
                }else{
                    flips++; // if we enounter 0s after we encounter 1s, we need to flip them. So we keep track of the count of 0s after the 1st one
                }
                // But what if instead of flipping 1s instead of 0s gives us lesser no. of steps
                // Check for that
                flips = Math.min(flips, ones); // min(flipping zeros after 1, flipping 1s);
            }
        }

        return flips;
    }
}