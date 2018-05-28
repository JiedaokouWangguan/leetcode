public class Question477{
    public int totalHammingDistance(int[] nums){
        int result = 0;
        for(int b = 0;b < 32;b++){
            int tmp = 0;
            for(int i = 0;i<nums.length;i++){
                tmp += (nums[i] >> b) & 1;
            }
            result += tmp * (nums.length - tmp);
        }
        return result;
    }
}
