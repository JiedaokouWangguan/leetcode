package leetcode.day8_29;

import java.util.ArrayList;
import java.util.List;

public class Question315 {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[][] mer = new int[n][3];
        int[][] buff = new int[n][3];
        for (int i = 0;i<n;i++) mer[i] = new int[]{nums[i], i, 0};
        mergeCount(mer, buff, 0, n-1);
        int[] res = new int[n];
        for (int i = 0;i<n;i++) res[mer[i][1]] = mer[i][2];
        List<Integer> result = new ArrayList<>(n);
        for (int i : res) result.add(i);
        return result;
    }

    private void mergeCount(int[][] mer, int[][] buff, int begin, int end){
        if (begin >= end) return;
        int mid = (begin + end)/2;
        mergeCount(mer, buff, begin, mid);
        mergeCount(mer, buff, mid+1, end);
        sort(mer, buff, begin, end);
    }

    private void sort(int[][] mer, int[][] buff, int begin, int end){
        int mid = (begin + end)/2;
        int i = begin;
        int j = mid + 1;
        int index = begin;
        while (i <= mid && j <= end){
            if(mer[i][0] <= mer[j][0]){
                mer[i][2] += j - mid - 1;
                buff[index++] = mer[i++];
            }
            else buff[index++] = mer[j++];
        }
        while (j <= end) buff[index++] = mer[j++];
        while (i <= mid){
            mer[i][2] += end - mid;
            buff[index++] = mer[i++];
        }
        for (int k = begin;k<=end;k++) mer[k] = buff[k];
    }
}
