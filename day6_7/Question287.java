public class Question287{
    public int findDuplicate(int[] nums){
        int n = nums.length;
        int begin = 1;
        int end = n-1;
        
        while(begin <= end){
            int mid = (begin + end)/2;
            int count = 0;    
            for(int num : nums){
                if(num <= mid){
                    count += 1;
                }
            }
            if(count <= mid)
                begin = mid+1;
            else
                end = mid-1;
        }
        return begin;
    }
}
