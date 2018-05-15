package leetcode.day5_14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Question811
{
    public static void main(String[] args)
    {
        subdomainVisits(new String[]{"9001 discuss.leetcode.com"});
    }
    public static List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : cpdomains)
        {
            String[] str = s.split(" ");
            String[] ss = str[1].split("\\.");
            String tmp = "";
            int count = Integer.parseInt(str[0]);
            for (int i = ss.length-1;i >= 0;i--)
            {
                if (i == ss.length-1)
                {
                    tmp = ss[i];
                }
                else
                {
                    tmp = ss[i] + "." + tmp;
                }

                if (map.containsKey(tmp))
                {
                    map.put(tmp, map.get(tmp) + count);
                }
                else
                {
                    map.put(tmp, count);
                }
            }
        }
        List<String> result = new ArrayList<>();
        Set<String> set = map.keySet();
        for (String s : set)
        {
            String tmp = map.get(s) + " " + s;
            result.add(tmp);
        }
        return result;
    }
}
