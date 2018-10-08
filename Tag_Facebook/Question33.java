public class Question33{
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int begin = 0;
        int end = nums.length-1;
        while(begin < end){
            int mid = (end - begin)/2 + begin;
            if(nums[mid] == target) return mid;
            if(nums[mid] > nums[0] && target > nums[0]){
                if(nums[mid] < target){
                    begin = mid + 1;
                }
                else{
                    end = mid -1 ;
                }
            }
            else{
                if(nums[mid] < target){
                    end = mid - 1;
                }
                else{
                    begin = mid + 1;
                }
            }
        }
        return -1;
    }
}
