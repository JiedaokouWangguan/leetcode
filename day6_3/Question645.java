public class Question645{
    public int[] findErrorNums(int[] nums){
        int[] nums1 = new int[nums.length+1];
        int[] result = new int[2];
        for(int i = 0;i<nums.length;i++){
            nums1[nums[i]] += 1;
            if(nums1[nums[i]] == 2)
                result[0] = nums[i];
        }
        for(int i = 1;i<nums1.length;i++){
            if(nums1[i] == 0){
                result[1] = i;
                break;
            }
        }
        return result;
    }
}
