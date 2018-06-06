import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Question609{
    public List<List<String>> findDuplicate(String[] paths){
        HashMap<String, List<String>> map  = new HashMap<>();
        List<List<String>> list = new ArrayList<>();
        
        for(String s : paths){
            String[] ss = s.split(" ");
            String dir = ss[0];
            for(int i = 1;i<ss.length;i++){
                String tmpS = ss[i];
                String fileName = tmpS.substring(0, tmpS.indexOf("("));
                String content = tmpS.substring(tmpS.indexOf("(")+1, tmpS.length()-1);
                if(!map.containsKey(content)){
                    map.put(content, new ArrayList<String>());
                }
                map.get(content).add(dir+"/"+fileName);
                if(map.get(content).size() ==2)
                    list.add(map.get(content));
            }
        }
        return list;
    }
}
