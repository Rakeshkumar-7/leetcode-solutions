class Solution {
    public int totalFruit(int[] fruits) {
        int i = 0;
        int j = 0;
        int max = 0;
        Map<Integer, Integer> count = new HashMap<>();
        while(j < fruits.length){
            if(count.size() > 2){
                while(count.size() > 2){
                    // System.out.println(count);
                    int curCnt = count.get(fruits[i]);
                    if(curCnt == 1){
                        count.remove(fruits[i]);
                    }else{
                        count.put(fruits[i], curCnt-1);
                    }
                    i++;
                }
                // System.out.println(count);
                // System.out.println(i + " - over");
            }
            // System.out.println(count + " - normal");
            count.put(fruits[j], count.getOrDefault(fruits[j], 0) + 1);
            if(count.size() <= 2){
                max = Math.max(max, j - i + 1);
            }
            j++;
        }
        return max;
    }
}