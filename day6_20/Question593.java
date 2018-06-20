import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class Question593{
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        ArrayList<int[]> list = new ArrayList<>();                
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        Collections.sort(list, new Comparator<int[]>(){
            @Override
            public int compare(int[] i1, int[] i2){
                if(i1[0] == i2[0])
                    return i1[1] - i2[1];
                else
                    return i1[0] - i2[0];
            }
        });

        p1 = list.get(0);
        p2 = list.get(1);
        p3 = list.get(2);
        p4 = list.get(3);
        int s1 = getDis(p1, p2);
        int s2 = getDis(p1, p3);
        int s3 = getDis(p4, p2);
        int s4 = getDis(p4, p3);
        if(s1 == 0)
            return false;
        int s5 = getDis(p1, p4);
        int s6 = getDis(p2, p3);
        
        boolean b1 = s1 == s2 && s2 == s3 && s3 == s4;
        boolean b2 = s5 == s6;
        return b1 && b2;
    }
    private int getDis(int[] p1, int[] p2){
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
