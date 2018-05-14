package leetcode;

/**
 * Created by Song on 2018/5/13.
 */
public class Test
{
    public static void main(String[] args)
    {
        String s = "asdf   asdf sffsdfsdf\tsdfsdfsdf";
        String[] ss = s.split("(\\s)+");
        for (String sss : ss)
        {
            System.out.println(sss);
        }
    }
}
