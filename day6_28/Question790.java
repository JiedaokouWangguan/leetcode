public class Question790{
    public int numTilings(int N) {
        int[] v = new int[Math.max(N+1, 4)];
        int md =(int)Math.pow(10, 9);
        md += 7;
        v[0] = 1;
        v[1]=1;
        v[2]=2;
        v[3]=5;
        if(N<=3)
            return v[N];
        for(int i=4;i<=N;++i){
            long tmp = 0l;
            tmp = 2*v[i-1]+v[i-3]; 
            v[i] = (int)(tmp % md);
        }
        return v[N];
    }
}
