public class Question153{
    public int findMin(int[] nums){
        if(nums[0] < nums[nums.length-1])
            return nums[0];
        
        int begin = 0;
        int end = nums.length-1;
        while(begin <= end){
            int mid = (begin + end)/2;
            if(nums[mid] > nums[0]){
                begin = mid+1;
            }
            else if(mid < nums[0]){
                if((mid == nums.length-1 && nums[mid] < nums[mid-1]) || (mid < nums.length-1 && nums[mid] < nums[mid-1] && nums[mid] < nums[mid+1])  )
                    return nums[mid-1];
                else{
                    end = mid-1;
                }
            }
        }
        return 0;
    }
}
