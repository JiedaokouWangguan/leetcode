package leetcode.day5_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Song on 2018/5/21.
 */
public class Question406
{
    public int[][] reconstructQueue(int[][] people)
    {
        int n = people.length;
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                else
                    return o2[0] - o1[0];
            }
        });

        ArrayList<int[]> arrayList = new ArrayList<>();
        for (int i = 0;i<n;i++)
        {
            arrayList.add(people[i][1], people[i]);
        }

        return arrayList.toArray(new int[n][]);
    }
}
