package leetcode.day5_20;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Song on 2018/5/20.
 */
public class Question821
{

    /*
        public int[] shortestToChar(String S, char C) {
        int n = S.length();
        int[] res = new int[n];
        int pos = -n;
        for (int i = 0; i < n; ++i) {
            if (S.charAt(i) == C) pos = i;
            res[i] = i - pos;
        }
        for (int i = n - 1; i >= 0; --i) {
            if (S.charAt(i) == C)  pos = i;
            res[i] = Math.min(res[i], Math.abs(i - pos));
        }
        return res;
    }
    因为这个题从左到右和从右到左有类似的地方，所以可以通过两次遍历得到答案
     */
    public int[] shortestToChar(String S, char C) {
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0;i<S.length();i++)
        {
            if (S.charAt(i) == C)
            {
                queue.offer(i);
            }
        }

        int last = -10000;
        int[] result = new int[S.length()];
        for (int i = 0;i<S.length();i++)
        {
            int peek;
            if (queue.size() == 0)
                peek = 20000;
            else
                peek = queue.peek();
            if (i == peek)
            {
                result[i] = 0;
                queue.poll();
                last = i;
            }
            else
            {
                result[i] = Math.min(peek - i, i - last);
            }
        }
        return result;
    }
}
