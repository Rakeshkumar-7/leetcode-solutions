class Solution {
    public boolean isUgly(int n) {
        Boolean updated = false;
        if(n == 0){
            return false;
        }
        while(true){
            if(n % 2 == 0){
                n = n/2;
                updated = true;
            }
            if(n % 3 == 0){
                n = n/3;
                updated = true;
            }
            if(n % 5 == 0){
                n = n/5;
                updated = true;
            }

            if(!updated){
                break;
            }else{
                updated = false;
            }
        }
        return (n == 1);
    }
}