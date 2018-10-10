import java.util.List;
import java.util.ArrayList;

public class Question422{
    public boolean validWordSquare(List<String> words) {
        List<String> verti = new ArrayList<>();
        List<String> hori = words;
        int index = 0;
        while(true){
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i<hori.size();i++){
                if(hori.get(i).length() <= index) break;
                sb.append(hori.get(i).charAt(index));
            }
            if(sb.length() == 0) break;
            verti.add(sb.toString());
            index += 1;
        }
        if(verti.size() != hori.size()) return false;
        for(int i = 0;i<hori.size();i++){
            if(!verti.get(i).equals(hori.get(i))) return false;
        }
        return true;
    }
}
