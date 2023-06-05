class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        double slope;
        try{
            slope = (coordinates[1][1] - coordinates[0][1])/(coordinates[1][0]-coordinates[0][0]);
        }catch(ArithmeticException e){
            slope = Double.POSITIVE_INFINITY;
        }
        double intercept = coordinates[1][1] - slope*coordinates[1][0];
        if(slope == Double.POSITIVE_INFINITY){
            intercept = Double.POSITIVE_INFINITY;
        }
        for(int i=1; i<coordinates.length-1; i++){
            double nextSlope;
            try{
                nextSlope = (coordinates[i+1][1] - coordinates[i][1])/(coordinates[i+1][0]-coordinates[i][0]);
            }catch(ArithmeticException e){
                nextSlope = Double.POSITIVE_INFINITY;
            }
            double nextIntercept = coordinates[i][1] - nextSlope*coordinates[i][0];
            if(nextSlope == Double.POSITIVE_INFINITY){
                nextIntercept = Double.POSITIVE_INFINITY;
            }
            if(slope != nextSlope || intercept != nextIntercept){
                return false;
            }
        }
        return true;
    }
}