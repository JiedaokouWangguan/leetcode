public class Question395{
    public int longestSubstring(String s, int k) {
        char[] chars = s.toCharArray();
        int result = 0;
        for(int i = 1;i<=26;i++){
            int begin = 0;
            int end = 0;
            int uniq = 0;
            int numNoLessThank = 0;
            int[] count = new int[26];
            while(end < chars.length){
                if(uniq <= i){
                    char c = chars[end];
                    if(count[c - 'a'] == 0)
                        uniq += 1;
                    count[c - 'a'] += 1;
                    if(count[c - 'a'] == k)
                        numNoLessThank += 1;
                    end += 1;
                }
                else{
                    char c = chars[begin];
                    if(count[c - 'a'] == k)
                        numNoLessThank -= 1;
                    count[c - 'a'] -= 1;
                    if(count[c - 'a'] == 0)
                        uniq -= 1;
                    begin += 1;
                }
                if(numNoLessThank == uniq && uniq == i)
                    result = Math.max(result, end - begin);
            }
        }
        return result;
    }
}
