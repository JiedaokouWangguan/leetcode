import java.util.HashMap;

public class Question659{
    public boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> seq = new HashMap<>();
        for(int i :nums) freq.put(i, freq.getOrDefault(i, 0)+1);
        for(int i : nums){
            if(freq.get(i) == 0) continue;
            else if(seq.getOrDefault(i, 0) > 0){
                seq.put(i, seq.get(i)-1);
                seq.put(i+1, seq.getOrDefault(i+1, 0) + 1);
            }
            else if(freq.getOrDefault(i+1, 0) > 0 && freq.getOrDefault(i+2, 0) > 0){
                freq.put(i+1, freq.get(i+1) - 1);
                freq.put(i+2, freq.get(i+2) - 1);
                seq.put(i+3, seq.getOrDefault(i+3, 0) + 1);
            }
            else return false;
            freq.put(i, freq.get(i) - 1);
        }
        return true;
    }
}
