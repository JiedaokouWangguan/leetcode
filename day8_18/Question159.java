public class Question159{
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] count = new int[128];
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int max = 0;
        int uniq = 0;
        int len = s.length();
        while (right < len) {
            char r = chars[right];
            char l = chars[left];
            if (uniq < 2 || uniq == 2 && count[r] != 0) {
                // 开始计算right
                count[r] += 1;
                if (count[r] == 1) uniq += 1;
                if (uniq <= 2) max = Math.max(max, right - left + 1);
                right += 1;
            } else {
                // 左移left
                count[l] -= 1;
                if (count[l] == 0) uniq -= 1;
                left += 1;
            }
        }
        return max;
    }
}
