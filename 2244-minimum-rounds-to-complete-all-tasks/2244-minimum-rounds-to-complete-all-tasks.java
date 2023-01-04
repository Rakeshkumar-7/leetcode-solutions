class Solution {
    private int[] sumOf2And3(int n){
        int a = (int)Math.ceil(n/3.0); // co. eff of 3
        int b = 0; // co. eff of 2
        int sum = 0;
        while(a >= 0){
            sum = 3*a + 2*b;
            if(sum < n){
                return new int[]{-1,-1};
            }else if(sum > n){
                a--;
                b++;
            }else{
                break;
            }
        }
        if(sum == n){
            return new int[]{a,b};
        }
        return new int[]{-1,-1};
    }
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int x: tasks){
            count.put(x, count.getOrDefault(x, 0) + 1);
        }
        if(tasks.length <= 3 && count.size() >= 2){
            return -1;
        }

        int i = 0;
        int rounds = 0;
        // System.out.println(count);        
        for(Map.Entry<Integer, Integer> entry: count.entrySet()){
            int[] coeff = sumOf2And3(entry.getValue());
            // System.out.println(entry.getValue());
            // System.out.println(Arrays.toString(coeff));
            if(coeff[0] == -1){
                return -1;
            }
            rounds += coeff[0] + coeff[1];
        }
        return rounds;
    }
}