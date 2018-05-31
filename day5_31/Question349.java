import java.util.HashSet;

public class Question349{
    public int[] intersection(int[] nums1, int[] nums2){
        HashSet<Integer> n1 = new HashSet<>();
        for(int n : nums1) n1.add(n);

        HashSet<Integer> result = new HashSet<>();
        for(int n : nums2){
            if(n1.contains(n))
                result.add(n);
        }
        int[] ret = new int[result.size()];
        int index = 0;
        for(int n : result){
            ret[index++] = n;
        }
        return ret;
    }
}
