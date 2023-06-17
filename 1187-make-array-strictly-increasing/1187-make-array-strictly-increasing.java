class Solution {
    private int util(int[] arr1, int[] arr2, Map<Pair<Integer, Integer>, Integer> dp, int cur, int prev, int k){
        if(cur == arr1.length){
            return 0;
        }

        if(dp.containsKey(new Pair<>(cur, prev))){
            return dp.get(new Pair<>(cur, prev));
        }
        
        int cost = 2001;
        // if strictly increase, move the pointer forward. No cost in current step
        if(arr1[cur] > prev){
            cost = util(arr1, arr2, dp, cur + 1, arr1[cur], k);
        }

        
        // Binary search the required val, since its sorted
        int left = k;
        int right = arr2.length;
        int mid;
        while(left < right){
            mid = (left + right)/2;
            if(arr2[mid] <= prev){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        
        // Assume that you've done arr1[cur] = arr2[left]. Pass it as prev. Include this step's cost
        if(left < arr2.length){
            cost = Math.min(cost, 1 + util(arr1, arr2, dp, cur + 1, arr2[left], left));
        }

        dp.put(new Pair<>(cur, prev), cost);

        return cost;
    }

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);

        Map<Pair<Integer, Integer>, Integer> dp = new HashMap<>();

        int cost = util(arr1, arr2, dp, 0, -1, 0);

        if(cost == 2001) return -1;

        return cost;
    }
}