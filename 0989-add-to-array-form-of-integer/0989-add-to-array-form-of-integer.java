class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new LinkedList();
        int carry = 0;
        for(int i=num.length-1; i>=0; i--){
            int sum = num[i] +  (k % 10) + carry;
            k /= 10;
            carry = (sum > 9)?(sum/10):0;
            sum = sum % 10;
            res.add(0, sum);
        }
        while(k != 0){
            int sum = (k % 10) + carry;
            k /= 10;
            carry = (sum > 9)?(sum/10):0;
            sum = sum % 10;
            res.add(0, sum);
        }
        if(carry != 0){
            res.add(0, carry);
        }
        return res;
    }
}