import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
public class Question819{
    public String mostCommonWord(String paragraph, String[] banned){
        StringBuilder sb = new StringBuilder();
        HashSet<String> set = new HashSet<>();
        for(String s : banned){ set.add(s); }
        paragraph = paragraph.toLowerCase();
        for(int i = 0;i<paragraph.length();i++){
            char c = paragraph.charAt(i);
            if(c == ' ' || (c >= 'a' && c <= 'z')){
                sb.append(c);
            }
        }
        String newParagraph = sb.toString();
        Scanner scanner = new Scanner(newParagraph);
        HashMap<String, Integer> map = new HashMap<>();
        while(scanner.hasNext()){
            String s = scanner.next();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2){
                return e2.getValue() - e1.getValue();
            }
        });
        for(Map.Entry<String, Integer> e : list){
            if(!set.contains(e.getKey())){
                return e.getKey();
            }
        }
        return null;
    }
}
