 class Solution {       // BY DSU
    List<Integer> rank;
    List<Integer> parent;

    public Solution() {}

    public int findPar(int node) {
        if (node == parent.get(node)) return node;
        int ulp = findPar(parent.get(node));
        parent.set(node, ulp); // path compression
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int pu = findPar(u);
        int pv = findPar(v);
        if (pu == pv) return;
        if (rank.get(pu) < rank.get(pv)) {
            parent.set(pu, pv);
        } else if (rank.get(pu) > rank.get(pv)) {
            parent.set(pv, pu);
        } else {
            parent.set(pv, pu);
            rank.set(pu, rank.get(pu) + 1);
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        rank = new ArrayList<>(Collections.nCopies(n, 0));
        parent = new ArrayList<>();
        for (int i = 0; i < n; i++) parent.add(i);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    unionByRank(i, j);
                }
            }
        }

        /*int count = 0;
        for (int i = 0; i < n; i++) {
            if (findPar(i) == i) count++;
        }*/
        Set<Integer> s=new HashSet<>();
        for (int i = 0; i < n; i++) {
            s.add(findPar(i));
        }


        return s.size();
    }
}


/*class Solution {
    boolean []vis;
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        vis=new boolean[n];
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<n;i++){
            l.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j]==1 && i!=j){
                    l.get(i).add(j);
                }
            }
        }
        int c=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                c++;
                dfs(i,l);
            }
        }
        return c;
    }
    public void dfs(int node, List<List<Integer>> l){
        vis[node]=true;
        for(int connect: l.get(node)){
            if((!vis[connect])){
                dfs(connect,l);
            }
        }
    }

}*/