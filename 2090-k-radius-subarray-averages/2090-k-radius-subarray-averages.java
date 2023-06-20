class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        System.out.println(n);
        int sub = 2*k + 1;

        int[] res = new int[n];
        for(int i=0; i<k && i < n; i++){
            res[i] = -1;
            res[n-i-1] = -1;
        }

        int i = 0;
        int j = 0;
        long sum = 0;
        while(j < n){
            sum += nums[j];
            if(j-i+1 == sub){
                res[i+k] = (int)(sum/sub);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return res;
    }
}