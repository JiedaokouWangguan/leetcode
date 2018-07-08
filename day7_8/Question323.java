public class Question323{
    public int countComponents(int n, int[][] edges) {
        int[] com = new int[n];
        for(int i = 0;i<n;i++)
            com[i] = i;
        
        int result = n;
        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];
            int rootFrom = getRoot(com, from);
            int rootTo = getRoot(com, to);
            if(rootFrom != rootTo){
                result -= 1;
                com[rootFrom] = rootTo;
            }
        }
        return result;
    }

    private int getRoot(int[] com, int index){
        while(com[index] != index){
            com[index] = com[com[index]];
            index = com[index];
        }
        return index;
    }
}
