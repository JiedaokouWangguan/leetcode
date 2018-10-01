public class Question162{
    // 2.28 - 2.40, 13mins
    public int findPeakElement(int[] nums) {
        return getFirst(nums, 0, nums.length-1);
    }                                       

    private int getFirst(int[] nums, int begin, int end){
        if(begin > end) return nums.length-1;
        int mid = (end-begin)/2 + begin; 
        int left = getValue(nums, mid-1);
        int right = getValue(nums, mid+1);
        int value = getValue(nums, mid); 
        if(left > value) return getFirst(nums, begin, mid-1);                                                                                
        else if(right < value){             
            return Math.min(mid, getFirst(nums, begin, mid-1));
        }                                   
        else{                               
            return Math.min(getFirst(nums, begin, mid-1), getFirst(nums, mid+1, end));
        }                                   
    }                                       

    private int getValue(int[] nums, int index){
        if(index == -1 || index == nums.length) return Integer.MIN_VALUE;
        else return nums[index];            
    }  
}
