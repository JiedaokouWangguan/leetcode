public class Question31{
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n-1;
        for(;i>=1;i--){
            if(nums[i] > nums[i-1]) break;
        }   
        if(i == 0){ 
            getReverse(nums, 0, n-1);
            return;
        }   
        int num1 = nums[i-1];
        for(int j = i;j<n;j++){
            if(nums[j] > num1){
                nums[i-1] = nums[j];
            } 
            else{
                nums[j-1] = num1;
                break;
            } 

            if(j == n-1) nums[j] = num1;                                                       

        }   
        getReverse(nums, i, n-1);                                                              
    }         

    private void getReverse(int[] nums, int begin, int end){
        while(begin < end){
            int tmp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = tmp;
            begin += 1;
            end -= 1;
        }   
    }
}
