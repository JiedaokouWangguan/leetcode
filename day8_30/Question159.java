public class Question159{
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char[] chars = s.toCharArray();
        int[] count = new int[128];
        int begin = 0;
        int end = 0;
        int unique = 0;
        int result = 0;
        int n = s.length();
        while(end < n){
            char cBegin = chars[begin];
            char cEnd = chars[end];
            if(unique < 2 || unique == 2&&count[cEnd] != 0){
                if(count[cEnd] == 0) unique += 1;
                count[cEnd] += 1;
                end += 1;
            }
            else{
                if(count[cBegin] == 1) unique -= 1;
                count[cBegin] -= 1;
                begin += 1;
            }
            result = Math.max(result, end - begin);
        }
        return result;
    }
}
