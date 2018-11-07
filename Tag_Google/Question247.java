import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Question247{
    String[] evenStrs = new String[]{"00", "11", "69", "96", "88"};
    String[] oddStrs = new String[] {"0", "1", "8"};

    String[] startStrs = new String[]{"11", "69", "96", "88"};
    public List<String> findStrobogrammatic(int n) {
        if(n == 0) return new ArrayList<>();
        if(n == 1) return new ArrayList<>(Arrays.asList(oddStrs));
        if(n == 2) return new ArrayList<>(Arrays.asList(startStrs));

        return getList(n-2, new ArrayList<>(Arrays.asList(startStrs)));    
    }

    private List<String> getList(int n, List<String> curList){
        if(n == 0) return curList;
        String[] tmpList = null;

        if(n == 1) tmpList = oddStrs;
        else tmpList = evenStrs;
        List<String> result = new ArrayList<>();
        for(String str : curList){
            for(String s : tmpList){
                int len = str.length()/2;
                result.add(str.substring(0, len) + s + str.substring(len));
            }
        }
        if(n == 1) return result;
        else return getList(n-2, result);
    }
}
