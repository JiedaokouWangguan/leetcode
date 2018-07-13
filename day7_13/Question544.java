import java.util.List;
import java.util.ArrayList;

public class Question544{
    public String findContestMatch(int n) {
        List<String> result = new ArrayList<String>(n);
        for(int i = 1;i<=n;i++)
            result.add(""+i);
        while(result.size() != 1)
            result = getList(result);
        return result.get(0);
    }

    private List<String> getList(List<String> list){
        int len = list.size();
        for(int i = 0;i<len/2;i++){
            String tmp = "(" + list.get(i) + "," + list.get(len-i-1)  + ")";
            list.set(i, tmp);
            list.remove(len-i-1);
        }
        return list;
    }
}
