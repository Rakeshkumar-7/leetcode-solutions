class UnionFind{
    Map<Character, Character> parent;
    // Map<Character, Integer> size;
    public UnionFind(){
        parent = new HashMap<Character, Character>();
        // size = new HashMap<Character, Integer>();
    }
    public Character getParent(Character i){
        if(!parent.containsKey(i)){
            parent.put(i, i);
            return i;
        }
        if(parent.get(i) == i){
            return i;
        }
        parent.put(i, getParent(parent.get(i)));
        return parent.get(i);
    }
    public Boolean union(Character i, Character j){
        i = this.getParent(i);
        j = this.getParent(j);
        if(i == j){
            return false;
        }

        // Using the characters themselves instead of size[] to perform union operation
        if(i < j){
            parent.put(j, i);
        }else{
            parent.put(i, j);
        }
        return true;
    }
}

class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        UnionFind uf = new UnionFind();
        for(int i=0; i<s1.length(); i++){
            uf.union(s1.charAt(i), s2.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<baseStr.length(); i++){
            Character minLex = uf.getParent(baseStr.charAt(i));
            sb.append(minLex);
        }

        return sb.toString();
    }
}