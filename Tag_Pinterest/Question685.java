public class Question685{
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        int[] group = new int[n+1];
        for(int i = 0;i<parent.length;i++){
            parent[i] = i;
            group[i] = i;
        }
        int[] first = null;
        int[] second = null;
        int[] last = null;
        for(int i = 0;i<edges.length;i++){
            int[] edge = edges[i];
            int p = edge[0];
            int c = edge[1];
            if(parent[c] != c){
                first = new int[]{parent[c], c};
                second = new int[]{p, c};
                continue;
            }
            parent[c] = p;
            int pGroup = findGroup(group, p);
            int cGroup = findGroup(group, c);
            if(pGroup != cGroup){
                group[cGroup] = pGroup;
            }
            else{
                last = new int[]{p, c};
            }
        }
        if(last == null) return second;
        if(first == null) return last;
        return first;
    }

    private int findGroup(int[] group, int i){
        while(group[i] != group[group[i]]){
            group[i] = group[group[i]];
        }
        return group[i];
    }
}
