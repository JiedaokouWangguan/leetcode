import java.util.List;
import java.util.ArrayList;

public class Question386_1{
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<10;++i){
            dfs(i, n, res); 
        }
        return res;
    }
    public void dfs(int cur, int n, List<Integer> res){
        if(cur>n)
            return;
        else{
            res.add(cur);
            for(int i=0;i<10;++i){
                dfs(10*cur+i, n, res);
            }
        }
    }
}
