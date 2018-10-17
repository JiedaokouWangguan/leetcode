public class Question918{
    public int maxSubarraySumCircular(int[] A) {    
        if(A == null || A.length == 0) return 0;    
        int min = A[0];                             
        int max = A[0];                             
        int curMax = A[0];                          
        int curMin = A[0];                          
        int sum = A[0];                                
        for(int i = 1;i<A.length;i++){              
            curMin = Math.min(A[i], curMin + A[i]);
            curMax = Math.max(A[i], curMax + A[i]);
            max = Math.max(max, curMax);            
            min = Math.min(min, curMin);            
            sum += A[i];                            
        }                                           
        return max > 0?Math.max(max, sum - min):max;                                                                                                                               
    }
}
