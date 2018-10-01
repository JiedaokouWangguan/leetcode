import java.util.List;
import java.util.ArrayList;
import java.util.TreeMap;

public class Question315{   
    // 1.43 - 2.00, 18mins
    public List<Integer> countSmaller(int[] nu) {
        if(nu == null || nu.length == 0) return new ArrayList<Integer>();
        int[][] nums = new int[nu.length][3];
        for(int i = 0;i<nu.length;i++){
            nums[i][0] = nu[i];                                                                                                              
            nums[i][1] = i;
            nums[i][2] = 0;
        }
        sort(nums, new int[nu.length][3], 0, nu.length-1);
        int[] res = new int[nu.length];
        for(int i = 0;i<res.length;i++){
            int index = nums[i][1];
            int count = nums[i][2];
            res[index] = count;
        }
        List<Integer> result = new ArrayList<>();
        for(int i : res){
            result.add(i);
        }
        return result;
    }    

    private void sort(int[][] nums, int[][] tmp, int begin, int end){
        if(begin == end) return;
        int mid = (end - begin)/2 + begin;
        sort(nums, tmp, begin, mid);
        sort(nums, tmp, mid+1, end);
        merge(nums, tmp, begin, end);
    }    

    private void merge(int[][] nums, int[][] tmp, int begin, int end){
        int mid = (end - begin)/2 + begin;
        int i = begin;
        int j = mid+1;
        int index = begin;
        while(i <= mid && j <= end){
            if(nums[i][0] > nums[j][0]){
                tmp[index++] = nums[j++];
            }
            else{
                nums[i][2] += j - (mid+1);
                tmp[index++] = nums[i++];
            }
        }
        while(j <= end){
            tmp[index++] = nums[j++];
        }
        while(i <= mid){
            nums[i][2] += j - (mid + 1);
            tmp[index++] = nums[i++];
        }
        for(int k = begin ; k<=end;k++){
            nums[k] = tmp[k];
        }
    }
}
