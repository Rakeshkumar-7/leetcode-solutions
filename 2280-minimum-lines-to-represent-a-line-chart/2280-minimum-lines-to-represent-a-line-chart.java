import java.math.BigDecimal;
import java.math.MathContext;
class Solution {
    public int minimumLines(int[][] stockPrices) {
        if(stockPrices.length == 1){
            return 0;
        }
        Arrays.sort(stockPrices, (a,b) -> Integer.compare(a[0], b[0]));
        int count = 1;
        for(int i=2; i<stockPrices.length; i++){
            BigDecimal slope1 = (new BigDecimal(stockPrices[i-2][1] - stockPrices[i-1][1])).divide(new BigDecimal(stockPrices[i-2][0] - stockPrices[i-1][0]), MathContext.DECIMAL128);
            BigDecimal slope2 = (new BigDecimal(stockPrices[i-1][1] - stockPrices[i][1])).divide(new BigDecimal(stockPrices[i-1][0] - stockPrices[i][0]), MathContext.DECIMAL128);
            if(slope1.compareTo(slope2) != 0){
                count++;
            }
        }
        return count;
    }
}