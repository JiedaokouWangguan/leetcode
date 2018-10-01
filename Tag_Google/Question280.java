public class Question280{
    // 2.20 - 2.23, 4mins
    public void wiggleSort(int[] nums) {
        for(int i = 0;i<nums.length;i++){
            if(i % 2 == 1){
                if(nums[i] < nums[i-1]) swap(nums, i, i-1);
            }
            else{
                if(i != 0 && nums[i] > nums[i-1]) swap(nums, i, i-1);
            }
        }   
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
