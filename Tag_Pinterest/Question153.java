public class Question153{
    public int findMin(int[] nums) {
        int begin = 0;
        int end = nums.length-1;
        while(begin < end){
            int mid = (end - begin)/2 + begin;
            if(nums[mid] > nums[end]) begin = mid + 1;
            else end = mid;
        }
        return nums[end];
    }
}
