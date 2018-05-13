package leetcode;

/**
 * Created by Song on 2018/5/13.
 */
public class Question657
{
    public boolean judgeCircle(String moves)
    {
        int hori = 0;
        int verti = 0;
        for (int i = 0;i<moves.length();i++)
        {
            char c = moves.charAt(i);
            if (c == 'U')
                verti -= 1;
            else if(c == 'D')
                verti += 1;
            else if(c == 'L')
                hori -= 1;
            else if(c == 'R')
                hori += 1;
        }
        return hori == 0 && verti == 0;
    }
}
