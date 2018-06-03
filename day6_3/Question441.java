public class Question441{
    public int arrangeCoins(int n){
        if(n == 0)
            return 0;
        double i = 1;
        while(true){
            if( ((1 + (1+i)) * (i+1)) /2 >n )
                return (int)i;
            else
                i += 1;
        }
    }
}
