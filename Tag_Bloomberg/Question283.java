public class Question283{
    public void moveZeroes(int[] nums) {  
        int nonZeroIndex = 0;        
        int cur = 0;                 
        while(cur < nums.length){    
            if(nums[cur] != 0)    
                nums[nonZeroIndex++] = nums[cur];          
            cur += 1;                       
        }                            
        while(nonZeroIndex < nums.length){
            nums[nonZeroIndex++] = 0;                                           
        }                            
    }
}
