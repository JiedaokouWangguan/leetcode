public class Question765{
    public int minSwapsCouples(int[] row){
        int[] pos = new int[row.length];
        for(int i = 0;i<row.length;i++){
            pos[row[i]] = i;
        }

        int res = 0;
        for(int i = 0;i<row.length;i+=2){
            int pair = row[i] % 2 == 0? (row[i]+1) : (row[i] - 1);
            if(row[i+1] != pair){
                row[pos[pair]] = row[i+1];
                pos[row[i+1]] = pos[pair];
                res++;
            }
        }
        return res;
    }
}
