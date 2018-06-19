public class Question684{
    public int[] findRedundantConnection(int[][] edges) {
        int[] union = new int[edges.length+1];
        int curGroup = 1;
        for(int[] tmp : edges){
            int from = tmp[0];
            int to = tmp[1];
            if(union[from] == 0 && union[to] == 0){
                union[from] = from;
                union[to] = from;
            }
            else if(union[from] == 0){
                union[from] = getRoot(union, to);
            }
            else if(union[to] == 0){
                union[to] = getRoot(union, from);
            }
            else{
                if(getRoot(union, from) == getRoot(union, to)){
                    return tmp;
                }
                else{
                    int rootFrom = getRoot(union, from);
                    int rootTo = getRoot(union, to);
                    union[rootTo] = rootFrom;
                }
            }
        }
        return new int[0];
    }

    int getRoot(int[] union, int num){
        while(union[num] != num){
            union[num] = union[union[num]];
            num = union[num];
        }
        return num;
    }
}
