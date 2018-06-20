public class Question75{
    public void sortColors(int[] nums) {
        // 0 1 2
        // i k j 
        int i = 0;
        int j = nums.length-1;
        int k = j;
        while(i < k){
            while(nums[i] == 0 && i < k)
                i++;
            while(nums[j] == 2 && i < j)
                j--;
            if(nums[i] == 2 && nums[j] == 0){
                nums[i] = 0;
                nums[j] = 2;
                continue;
            }
            else{
                k = j-1;
                while(i < k && nums[k] == 1){
                    k--;
                }
                if(k < i)
                    continue;
                if(nums[k] == 0){
                    int tmp = nums[k];
                    nums[k] = nums[i];
                    nums[i] = tmp;
                }
                else{
                    int tmp = nums[k];
                    nums[k] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }
}
