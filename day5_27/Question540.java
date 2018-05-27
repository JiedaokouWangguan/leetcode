public class Question540{
    public int singleNonDuplicate(int[] nums){
        int start = 0;
        int end = nums.length-1;
        while(start <= end)
        {
            int mid = (start + end) / 2;
            if(mid % 2 != 0)
                mid--;
            if(nums[mid] != nums[mid+1])
                end = mid;
            else
                start = mid + 2;
        }
        return nums[start];
    }
}
