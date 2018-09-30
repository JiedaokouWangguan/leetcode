public class Question50{
    // 7.45 - 7.50
    public double myPow(double x, int n) {        
        return myPow1(x, n);                                                      
    }

    public double myPow1(double x, long n) {        
        if(n == 0) return 1;                      
        if(n < 0){                                
            n = -n;                               
            x = 1/x;                              
        }                                         
        return (n%2 == 0)?myPow1(x*x, n/2):x*myPow1(x*x, n/2);                                                       
    } 
}
