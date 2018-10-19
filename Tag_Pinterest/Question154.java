public class Question154{
    public int findMin(int[] nums) {
        int begin = 0;        
        int end = nums.length-1;
        while(begin < end){
            int mid = (end - begin)/2 + begin;
            if(nums[mid] > nums[end]) begin = mid + 1;
            else if(nums[mid] < nums[begin]) end = mid;
            else end -= 1;
        }                     
        return nums[end];                                                                                 
    }
}
