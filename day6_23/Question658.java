import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Question658{
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int index = findIndex(0, arr.length-1, arr, x);
        int i = index-1;
        int j = index;
        while(result.size() < k){
            if(i < 0)
                result.add(arr[j++]);
            else if(j >= arr.length)
                result.add(arr[i--]);
            else{
                if(arr[j] - x >= x - arr[i])
                    result.add(arr[i--]);
                else
                    result.add(arr[j++]);
            }
        }
        Collections.sort(result);
        return result;
    }

    private int findIndex(int begin, int end, int[] arr, int target){
        while(begin < end){
            int mid = begin + (end-begin)/2;
            if(arr[mid] == target)
                return mid;
            else if(arr[mid] > target){
                end = mid - 1;
            }
            else{
                begin = mid + 1;
            }
        }
        return begin;
    }
}
