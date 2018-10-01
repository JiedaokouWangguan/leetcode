import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.LinkedList;

public class Question406{
    // 11.36 - 11.43, 8mins
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>(){
            @Override
            public int compare(int[] i1, int[] i2){
                if(i1[0] == i2[0]) return i1[1] - i2[1];
                else return i2[0] - i1[0];
            }
        });
        List<int[]> result = new LinkedList<>();
        for(int[] i : people){
            result.add(i[0], i);
        }
        int[][] res = new int[people.length][2];
        for(int i = 0;i<result.size();i++){
            res[i][0] = result.get(i)[0];
            res[i][1] = result.get(i)[1];
        }
        return res;
    }
}
