public class Question283{
    public void moveZeroes(int[] nums){
        int indexBegin = 0;
        int indexEnd = 0;
        while(indexEnd < nums.length){
            if(nums[indexEnd] != 0){
                nums[indexBegin] = nums[indexEnd];
                indexBegin += 1;
            }
            indexEnd += 1;
        }
        while(indexBegin < nums.length){
            nums[indexBegin] = 0;
            indexBegin += 1;
        }
    }
}
