class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        List<Pair<Integer, Integer>> data = new LinkedList<>();
        for(int i=0; i<n; i++){
            data.add(new Pair<>(position[i], speed[i]));
        }
        Collections.sort(data, (x,y) -> y.getKey() - x.getKey());
        Stack<Double> time = new Stack<>();
        for(Pair<Integer, Integer> pair: data){
            Double cur = (double)(target - pair.getKey())/pair.getValue();
            if(time.size() == 0){
                time.add(cur);
            }else{
                if(cur > time.peek()){
                    time.push(cur);
                }
            }
        }

        return time.size();
    }
}