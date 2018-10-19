public class Question34{
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if(nums == null || nums.length == 0) return result;
        int begin = 0;
        int end = nums.length-1;
        while(begin < end){
            int mid = (end - begin)/2 + begin;
            if(nums[mid] >= target) end = mid;
            else begin = mid + 1;
        }               
        if(nums[begin] != target) return result;
        result[0] = end;
        begin = 0;   
        end = nums.length-1;
        while(begin < end){
            int mid = (end - begin + 1)/2 + begin;
            if(nums[mid] <= target) begin = mid;
            else if(nums[mid] > target) end = mid -1;
        }               
        result[1] = begin;  // 1 1 3 3                                                                                                                                                                                  
        return result;
    } 
}
