public class Question28{

    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null) return -1;
        if(haystack.equals(needle)) return 0;
        if(haystack.length() == 0) return -1;
        if(needle.length() == 0) return 0;
        char[] chars = haystack.toCharArray();
        char[] pattern = needle.toCharArray();
        int[] array = getArray(pattern);

        int index = 0;
        int i = 0;
        while(i < chars.length && index < pattern.length)
        {
            if(chars[i] == pattern[index]){
                index += 1;
                i += 1;
            }
            else{
                if(index != 0) index = array[index-1];
                else i+= 1;
            }
        }
        if(index == pattern.length) return i-index;
        return -1;
    }

    private int[] getArray(char[] chars){
        int i = 0;
        int j = 1;
        int[] result = new int[chars.length];
        result[0] = 0;
        while(j < chars.length){
            if(chars[j] == chars[i]){
                result[j] = i+1;
                j += 1;
                i += 1;
            }
            else{
                if(i != 0) i = result[i-1];
                else{
                    result[j] = 0;
                    j += 1;
                }
            }
        }
        return result;
    }
}
