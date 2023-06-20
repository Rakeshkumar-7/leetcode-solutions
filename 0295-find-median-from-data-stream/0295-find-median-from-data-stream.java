class MedianFinder {

    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    public MedianFinder() {
        left = new PriorityQueue<>((x,y) -> y-x); // max heap
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(left.size() == 0){
            left.add(num);
        }else if(num >= left.peek()){
            right.add(num);
        }else{
            left.add(num);
        }
        if(Math.abs(left.size() - right.size()) > + 1){
            if(left.size() > right.size()){
                right.add(left.poll());
            }else{
                left.add(right.poll());
            }
        }
    }
    
    public double findMedian() {
        int n = left.size() + right.size();
        if(n % 2 == 1){
            return left.size() > right.size() ? left.peek() : right.peek();
        }else{
            return ((double)left.peek() + right.peek())/2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */