public class Question31{

    // 2.22 - 2.31
    public void nextPermutation(int[] nums) {
        int index = nums.length-1;
        for(;index > 0;index--){
            if(nums[index] > nums[index-1])
                break;
        }   
        if(index == 0) {
            reverse(nums, 0, nums.length-1);
            return;
        }
        index -= 1;
        int k = index + 1;
        for(;k<nums.length;k++){
            if(nums[k] <= nums[index])
                break;
        }   
        k -= 1;
        int tmp = nums[index];
        nums[index] = nums[k];
        nums[k] = tmp;
        reverse(nums, index+1, nums.length-1);
    }
    private void reverse(int[] nums, int begin, int end){
        while(begin < end){
            int tmp = nums[begin];                                                                                      
            nums[begin] = nums[end];
            nums[end] = tmp;
            begin += 1;
            end -= 1;
        }   
    }
}
