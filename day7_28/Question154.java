public class Question154{
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        int leftMost = nums[0];
        int l = 0;
        int r = nums.length-1;
        while(l < r){
            int mid = l + (r-l)/2;
            if(nums[mid] < nums[r]){
                r = mid;
            }
            else if(nums[mid] > nums[r]){
                l = mid + 1;
            }
            else{
                r--;
            }
        }
        return nums[l];
    }
}
