import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;

public class Question315{
    public List<Integer> countSmaller(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        int n = nums.length;
        int[][] numbers = new int[n][3];
        for(int i = 0;i<n;i++){
            numbers[i][0] = nums[i]; // number
            numbers[i][1] = i; // original index
            numbers[i][2] = 0; // num of smaller numbers
        }
        mergeSort(numbers, 0, n-1, new int[n][3]);
        int[] res = new int[n];
        for(int i = 0;i<n;i++){
            int index = numbers[i][1];
            int numSmaller = numbers[i][2];
            res[index] = numSmaller;
        }
        List<Integer> list = new ArrayList<>(n);
        for(int i : res) list.add(i);
        return list;
    }

    private void mergeSort(int[][] num, int begin, int end, int[][] tmp){
        if(begin == end) return;
        int mid = (begin + end)/2;
        mergeSort(num, begin, mid, tmp);
        mergeSort(num, mid+1, end, tmp);
        merge(num, begin, end, tmp);
    }
    private void merge(int[][] num, int begin, int end, int[][] tmp){
        int mid = (begin+end)/2;
        int i = begin;
        int j = mid+1;
        int index = begin;
        while(i <= mid && j <= end){
            if(num[i][0] <= num[j][0]){
                num[i][2] += j-1-mid;
                tmp[index++] = num[i++];
            }
            else{
                tmp[index++] = num[j++];
            }
        }
        while(j <= end){
            tmp[index++] = num[j++];
        }
        while(i <= mid){
            num[i][2] += end - mid;
            tmp[index++] = num[i++];
        }
        for(int k = begin;k<=end;k++) num[k] = tmp[k];
    }
}
