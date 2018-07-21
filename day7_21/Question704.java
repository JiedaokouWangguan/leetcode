public class Question704{
    public int search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length-1;
        while(begin<= end){
            int mid = (end - begin)/2 + begin;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) end = mid-1;
            else begin = mid + 1;
        }
        return -1;
    }
}
