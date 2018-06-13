public class Question747{
    public int dominantIndex(int[] nums){
        Integer max1 = null;
        Integer max2 = null;
        int index = -1;
        for(Integer num : nums){
            index += 1;
            if(( max1 != null && num.equals(nums[max1]) ) || (max2 != null && num.equals(nums[max2])) )
                continue;
            if(max1 == null || num > nums[max1]){
                max2 = max1;
                max1 = index;
            }
            else if(max2 == null || num > nums[max2]){
                max2 = index;
            }
        }
        if(max2 == null)
            return 0;
        return nums[max1] * 1.0 / 2 >=  nums[max2]?max1 : -1;
    }
}
