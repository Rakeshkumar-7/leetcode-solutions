class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList();
        if(numRows == 0){
            return triangle;
        }
        List<Integer> row = new ArrayList();
        row.add(1);
        triangle.add(row);
        if(numRows == 1){
            return triangle;
        }

        for(int i=1; i<numRows; i++){
            Integer[] cur = new Integer[i+1];
            cur[0] = 1;
            cur[i] = 1;
            for(int j=1; j<i; j++){
                cur[j] = triangle.get(triangle.size() - 1).get(j-1) + triangle.get(triangle.size() - 1).get(j);
            }
            List<Integer> curRow = Arrays.asList(cur);
            triangle.add(curRow);
        }

        return triangle;
    }
}