public class Question484{
    public int[] findPermutation(String s) {
        int n = s.length()+1;
        int[] result = new int[n];
        for(int i = 0;i<n;i++) result[i] = i+1;
        int index = 0;
        while(index < s.length()){
            if(s.charAt(index) == 'I'){
                index += 1;
                continue;
            }            
            int left = index;
            int right = left+1;
            while(index < s.length() && s.charAt(index) == 'D'){
                right = index + 1;
                index += 1;
            }            
            reverse(result, left, right);
        }                
        return result;                                                                                                                                                                     
    }                    

    private void reverse(int[] result, int left, int right){
        while(left < right){
            result[left] ^= result[right];
            result[right] ^= result[left];
            result[left++] ^= result[right--];
        }                
    }
}
