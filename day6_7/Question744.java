public class Question744{
    public char nextGreatestLetter(char[] letters, char target){
        int n = letters.length;
        if(target < letters[0] || target >= letters[letters.length-1])
            return letters[0];

        char result = letters[letters.length-1];
        int begin = 0;
        int end = n-1;
        while(begin <= end){
            int mid = (begin + end) /2;
            char c = letters[mid];
            if(c <= target){
                begin = mid + 1;
            }
            else{
                result = (char)Math.min(result, c);
                end = mid - 1;
            }
        }
        return result;
    }
}
