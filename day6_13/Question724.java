public class Question724{
    public int pivotIndex(int[] nums){
        int sum = 0;
        for(int num : nums)
            sum += num;
        int leftSum = 0;
        for(int i = 0;i<nums.length;i++){
            int num = nums[i];
            if(leftSum == sum - leftSum - num)
                return i;
            leftSum += num;
        }
        return -1;
    }
}
