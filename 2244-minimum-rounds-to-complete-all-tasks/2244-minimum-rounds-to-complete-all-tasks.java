class Solution {
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
        for(int c: count.values()){
            if(c == 1){
                return -1;
            }
            rounds += c/3;
            if(c % 3 != 0) rounds++;            
        }
        return rounds;
    }
}