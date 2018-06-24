public class Question633{
    public boolean judgeSquareSum(int c){ 
        int right = (int)Math.sqrt(c);
        if(right * right == c)
            return true;  
        int left = 1;      
        while(left <= right){
            int res = left * left + right * right;
            if(res == c)
                return true;
            else if(res > c)
                right -= 1;
            else             
                left += 1;                                                      
        }                    
        return false;        
    }
}

