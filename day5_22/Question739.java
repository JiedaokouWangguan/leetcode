package leetcode.day5_22;

import java.util.Stack;

/**
 * Created by Song on 2018/5/22.
 */
public class Question739
{
    public int[] dailyTemperatures(int[] temperatures)
    {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = 0;i<temperatures.length;i++)
        {
            if (stack.size() == 0 || temperatures[stack.peek()] >= temperatures[i])
            {
                stack.push(i);
            }
            else
            {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i])
                {
                    int temIndex = stack.pop();
                    result[temIndex] = i - temIndex;
                }
                stack.push(i);
            }
        }
        return result;
    }
}
