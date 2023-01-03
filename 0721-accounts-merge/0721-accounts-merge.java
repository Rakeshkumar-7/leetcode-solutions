class DisjointSet{
    public int size[];
    public int parent[];
    DisjointSet(int n){
        size = new int[n];
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
    }

    public int getParent(int u){
        if(parent[u] == u){
            return u;
        }
        parent[u] = getParent(parent[u]);
        return parent[u];
    }

    public void union(int u, int v){
        int uP = getParent(u);
        int uV = getParent(v);
        
        if(uP == uV){
            return;
        }

        if(size[uP] > size[uV]){
            parent[uV] = uP;
            size[uP] += size[uV];
        }else{
            parent[uP] = uV;
            size[uV] += size[uP];
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        Map<String, Integer> parent = new HashMap<>();
        DisjointSet ds = new DisjointSet(accounts.size());
        for(int i=0; i<accounts.size(); i++){
            List<String> account = accounts.get(i);
            for(int j=1; j<account.size(); j++){
                if(parent.containsKey(account.get(j))){
                    ds.union(i, parent.get(account.get(j)));
                }else{
                    parent.put(account.get(j),i);
                }
            }
        }

        List<List<String>> merged = new ArrayList<>();
        for(int i=0; i<accounts.size(); i++){
            merged.add(new ArrayList<String>());
        }
        for(Map.Entry<String, Integer> entry: parent.entrySet()){
            int belongsTo = entry.getValue();
            int ultimateParent = ds.getParent(belongsTo);
            if(belongsTo == ultimateParent){
                merged.get(belongsTo).add(entry.getKey());
            }else{
                merged.get(ultimateParent).add(entry.getKey());
            }
        }

        List<List<String>> filtered = new ArrayList<>();
        for(int i=0; i<merged.size(); i++){
            List<String> account = merged.get(i);
            if(account.size() > 0){
                Collections.sort(account);
                account.add(0, accounts.get(i).get(0)); // name
                filtered.add(account);
            }
        }

        return filtered;
    }
}