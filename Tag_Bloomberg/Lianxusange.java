public class Lianxusange{
    public int test(int[] nums){
        int begin = 0;
        int end = nums.length-1;
        while(begin < end){
            int mid = (end - begin)/2 + begin;
            int tmp = mid;
            while(tmp > 0 && tmp % 3 != 0) tmp -= 1;
            if(nums[tmp] == nums[mid]) begin = mid + 1;
            else end = mid - 1;
        }
        return begin;
    }
}
