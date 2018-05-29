import java.util.HashSet;

public class Question769{
    public int maxChunksToSorted(int[] arr){
        int result = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<arr.length;i++){
            if(set.contains(i))
                set.remove(i);
            else
                set.add(i);

            int n = arr[i];
            if(set.contains(n))
                set.remove(n);
            else
                set.add(n);
            if(set.size() == 0)
                result += 1;
        }
        return result;
    }
}
