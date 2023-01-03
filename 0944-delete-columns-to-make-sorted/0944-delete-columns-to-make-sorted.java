class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        for(int i=0; i<strs[0].length(); i++){
            char prev = strs[0].charAt(i);
            for(int j=1; j<strs.length; j++){
                if(prev > strs[j].charAt(i)){
                    count++;
                    break;
                }else{
                    prev = strs[j].charAt(i);
                }
            }
        }
        return count;
    }
}