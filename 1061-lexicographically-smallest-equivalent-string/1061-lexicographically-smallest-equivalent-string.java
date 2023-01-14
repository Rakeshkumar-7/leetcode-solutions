class UnionFind{
    int[] parent;
    public UnionFind(){
        parent = new int[26];
        Arrays.fill(parent, -1);
    }
    public int getParent(int i){
        if(parent[i] == -1){
            parent[i] = i;
            return i;
        }
        if(parent[i] == i){
            return i;
        }
        parent[i] = getParent(parent[i]);
        return parent[i];
    }
    public Boolean union(int i, int j){
        i = this.getParent(i);
        j = this.getParent(j);
        if(i == j){
            return false;
        }

        // Using the characters themselves instead of size[] to perform union operation
        if(i < j){
            parent[j] = i;
        }else{
            parent[i] = j;
        }
        return true;
    }
}

class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        UnionFind uf = new UnionFind();
        for(int i=0; i<s1.length(); i++){
            uf.union(s1.charAt(i)-'a', s2.charAt(i)-'a');
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<baseStr.length(); i++){
            char minLex = (char)(uf.getParent(baseStr.charAt(i)-'a') + (int)'a');
            sb.append(minLex);
        }

        return sb.toString();
    }
}