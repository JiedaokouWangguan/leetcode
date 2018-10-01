import java.util.HashMap;
import java.util.HashSet;

public class Question843{
    // 6.58 - 7.14, 17mins
    public void findSecretWord(String[] wordlist, Master master) {
        HashSet<String> set = new HashSet<>();
        for(String str : wordlist) set.add(str);
        int times = 0;
        while(times < 10 && set.size() > 0){
            String s = getStr(set); 
            int count = master.guess(s);
            if(count == s.length()) return;
            set = getSet(set, count, s);
            times += 1;
        }
    }

    private HashSet<String> getSet(HashSet<String> set, int count, String str){
        HashSet<String> newSet = new HashSet<>();
        for(String s : set){
            if(count == getMatch(s, str))
                newSet.add(s);
        }
        return newSet;
    }

    private int getMatch(String s1, String s2){
        int count = 0;
        for(int i = 0;i<s1.length();i++){
            if(s1.charAt(i) == s2.charAt(i))
                count += 1;
        }
        return count;
    }

    private String getStr(HashSet<String> set){
        String res = null;
        int count = Integer.MAX_VALUE;
        for(String s1 : set){
            int tmpMax = 0;
            int[] times = new int[7];
            for(String s2 : set){
                int tmp = getMatch(s1, s2);
                times[tmp] += 1;
                tmpMax = Math.max(tmpMax, times[tmp]);
            }
            if(tmpMax < count){
                res = s1;
                count = tmpMax;
            }
        }
        return res;
    }

    
}

interface Master {
    public int guess(String word);
}
