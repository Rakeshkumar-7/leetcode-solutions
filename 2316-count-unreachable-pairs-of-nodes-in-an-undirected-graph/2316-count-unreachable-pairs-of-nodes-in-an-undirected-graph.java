class Solution {
    private long DFS(List<List<Integer>> adj, int vis[], int cur){
        vis[cur] = 1;
        long nodes = 1; // self
        for(int neighbor: adj.get(cur)){
            if(vis[neighbor] == 0){
                nodes += DFS(adj, vis, neighbor);
            }
        }
        return nodes;
    }

    public long countPairs(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);

        for(int[] edge: edges){
            uf.union(edge[0], edge[1]);
        }

        List<Long> components = uf.getParentSizes();

        // Calculating the result
        long result = 0;
        int left = n;
        for(int i=0; i<components.size(); i++){
            result += components.get(i)*(left - components.get(i));
            left -= components.get(i);
        }

        return result;
    }
}

class UnionFind{
    long size[];
    int parent[];

    public UnionFind(int n){
        this.size = new long[n];
        this.parent = new int[n];
        for(int i=0; i<n; i++){
            this.size[i] = 1;
            this.parent[i] = i;
        }
    }

    public Boolean union(int i, int j){
        i = this.getParent(i);
        j = this.getParent(j);
        if(i == j){ // already belongs to the same parent
            return false;
        }
        if(this.size[i] > this.size[j]){
            this.size[i] += this.size[j];
            this.parent[j] = i;
        }else{
            this.size[j] += this.size[i];
            this.parent[i] = j;
        }
        return true;
    }

    public int getParent(int i){
        if(this.parent[i] != i){
            this.parent[i] = this.getParent(parent[i]);
        }
        return this.parent[i];
    }

    public List<Long> getParentSizes(){
        List<Long> result = new ArrayList<>();
        for(int i=0; i<this.parent.length; i++){
            if(this.parent[i] == i){
                result.add(this.size[i]);
            }
        }
        return result;
    }

    @Override
    public String toString(){
        String a = "Size: " + Arrays.toString(size);
        String b = "Parent: " + Arrays.toString(parent);
        return a + "\n" + b;
    }
}