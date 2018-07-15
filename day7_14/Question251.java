import java.util.Iterator;
import java.util.List;

public class Vector2D {
    int indexList, indexEle;
    List<List<Integer>> vec; 

    public Vector2D(List<List<Integer>> vec2d) {
        indexList = 0;
        indexEle = 0;
        vec = vec2d;
    }

    public int next() {
        return vec.get(indexList).get(indexEle++);
    }

    public boolean hasNext() {
        while(indexList < vec.size()){
            if(indexEle < vec.get(indexList).size())
                return true;
            else{
                indexList++;
                indexEle = 0;
            }
        }
        return false;
    }
}
