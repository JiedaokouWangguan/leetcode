package leetcode.day5_23;

import java.util.TreeMap;

/**
 * Created by Song on 2018/5/23.
 */
public class Question731
{
    class MyCalendar {
        TreeMap<Integer, Integer> count;
        MyCalendar(){
            count = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            count.put(start, count.getOrDefault(start, 0) + 1);
            count.put(end, count.getOrDefault(end, 0) - 1);

            int active = 0;
            for (int c: count.values())
            {
                active += c;
                if (active >= 3)
                {
                    count.put(start, count.get(start) - 1);
                    count.put(end, count.get(end) + 1);
                    if (count.get(start) == 0)
                        count.remove(start);
                    return false;
                }
            }
            return true;
        }
    }
}
