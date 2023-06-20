class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int x: nums){
            set.add(x);
        }
        int max = 0;
        UnionFind uf = new UnionFind(set.size());
        for(int num: set){
            if(set.contains(num - 1)){
                uf.union(num-1, num);
            }else if(set.contains(num + 1)){
                uf.union(num+1, num);
            }else{
                uf.getSize(num);
            }
        }
        
        Map<Integer, Integer> size = uf.getSizes();
        for(int x: size.values()){
            max = Math.max(x, max);
        }

        return max;
    }
}

class UnionFind{
    Map<Integer, Integer> size;
    Map<Integer, Integer> parent;

    UnionFind(int n){
        size = new HashMap<>();
        parent = new HashMap<>();
    }

    int getParent(int x){
        if(parent.containsKey(x)){
            if(parent.get(x) != x){
                parent.put(x, this.getParent(parent.get(x)));
            }
            return parent.get(x);
        }else{
            parent.put(x, x);
        }
        return parent.get(x);
    }

    int getSize(int x){
        size.put(x, size.getOrDefault(x, 1));
        return size.get(x);
    }

    boolean union(int x, int y){
        x = this.getParent(x);
        y = this.getParent(y);
        this.getSize(x);
        this.getSize(y);
        if(x == y){
            return false;
        }else if(size.get(x) >= size.get(y)){
            size.put(x, size.get(x) + size.get(y));
            parent.put(y, x);
        }else{
            size.put(y, size.get(y) + size.get(x));
            parent.put(x, y);
        }

        return true;
    }

    Map<Integer, Integer> getSizes(){
        return size;
    }
}