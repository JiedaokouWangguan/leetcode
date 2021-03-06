import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import javafx.util.Pair;
import java.util.ArrayList;

public class Question826{
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<Pair<Integer, Integer>> jobs = new ArrayList<>();
        int N = profit.length, res = 0, i = 0, maxp = 0;
        for (int j = 0; j < N; ++j) jobs.add(new Pair<Integer, Integer>(difficulty[j], profit[j]));
        Collections.sort(jobs, Comparator.comparing(Pair::getKey));
        Arrays.sort(worker);
        for (int ability : worker) {
            while (i < N && ability >= jobs.get(i).getKey())
                maxp = Math.max(jobs.get(i++).getValue(), maxp);
            res += maxp;
        }
        return res;
    }
}
