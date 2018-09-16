import java.util.List;
import java.util.ArrayList;

public class Question267{
    public List<String> generatePalindromes(String s) {
        int count[] = new int[128];
        char[] chars = s.toCharArray();
        for(char c : chars) count[c] += 1;

        char odd = 0;
        for(int i = 0;i<128;i++){
            if(count[i] % 2 == 1){ 
                if(odd != 0) return new ArrayList<>();
                else{
                    count[i] -= 1;
                    odd = (char)(i);
                }   
            }   
        }   

        String cur = odd == 0?"":""+odd;   
        int target = odd == 0?s.length():s.length()-1;
        List<String> result = new ArrayList<>();
        backtrack(result, cur, count, target);
        return result;
    }       

    private void backtrack(List<String> result, String cur, int count[], int target){
        if(target == 0){ 
            result.add(cur);
            return;
        }   

        for(int i = 0;i<128;i++){
            if(count[i] == 0) continue;
            char c = (char)(i);
            count[i] -= 2;
            backtrack(result, c + cur + c, count, target-2);
            count[i] += 2;
        }                                                                                                                                                                                                   
    }  
}
