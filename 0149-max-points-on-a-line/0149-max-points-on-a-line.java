class Solution {
    public int maxPoints(int[][] points) {
        // if there is only a dot, then it lies on any line that passes throught that point
        if(points.length == 1){
            return 1;
        }
        HashMap<Pair<Double, Double>, Set<int[]>> lines = new HashMap<>();
        for(int i=0; i<points.length; i++){
            for(int j=i+1; j<points.length; j++){
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                // y = mx + c
                // m = (y2-y1)/(x2-x1);
                // c = y - mx
                double slope =  (double)(y2 - y1)/(x2 - x1);
                // edge case where x2 - x1 = 0 and slope becomes inifnity
                if(x2 - x1 == 0){
                    if(y2 - y1 >= 0){
                        slope = Integer.MAX_VALUE;
                    }else{
                        slope = Integer.MIN_VALUE;
                    }
                }
                double intercept = y1 - slope*x1;
                if(x2 - x1 == 0){
                    // If slope if infinte, their y-intercepts will be different
                    // So use x-intercept = x1 = x2
                    intercept = x1;
                }
                Pair<Double, Double> line = new Pair<>(slope, intercept);
                lines.computeIfAbsent(line, val -> new HashSet<int[]>()).add(points[i]);
                lines.get(line).add(points[j]);
            }
        }
        int max = 0;
        for(Set<int[]> linePoints: lines.values()){
            if(linePoints.size() > max){
                max = linePoints.size();
            }
        }
        return max;
    }
}