class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int x: arr){
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        int n = arr.length-1;

        if((max-min) % n != 0){
            return false;
        }

        int diff = (max - min)/n;
        
        if(diff == 0){
            return true;
        }

        Set<Integer> set = new HashSet<>();
        for(int x: arr){
            set.add(x);
            if((x - min) % diff != 0){
                return false;
            }
        }

        return set.size() == arr.length;
    }
}