import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class Question218{
    // 2.32 - 2.57, 26mins
    public List<int[]> getSkyline(int[][] buildings) {
        List<Item> data = new ArrayList<>();
        for(int[] i : buildings){
            Item itemBegin = new Item(i[0], i[2], 'b');
            Item itemEnd = new Item(i[1], i[2], 'e');
            data.add(itemBegin);
            data.add(itemEnd);
        }
        Collections.sort(data, new Comparator<Item>(){
            @Override
            public int compare(Item i1, Item i2){
                if(i1.x == i2.x){
                    if(i1.type == i2.type){
                        if(i1.type == 'b') return i2.height - i1.height;
                        else return i1.height - i2.height;
                    }
                    else{
                        if(i1.type == 'b') return -1;
                        else return 1;
                    }
                }
                else return i1.x - i2.x;
            }
        });

        TreeMap<Integer, Integer> queue = new TreeMap<>();
        queue.put(0, 1);

        List<int[]> result = new ArrayList<>();
        int curHeight = 0;
        for(Item i : data){
            if(i.type == 'b')
                queue.put(i.height, queue.getOrDefault(i.height, 0)+1);
            else{
                queue.put(i.height, queue.get(i.height)-1);
                if(queue.get(i.height) == 0) queue.remove(i.height);
            }

            Integer h = queue.lastKey();
            if(curHeight != h){
                curHeight = h;
                result.add(new int[]{i.x, curHeight});
            }
        }
        return result;
    }
}

class Item{
    int x;
    int height;
    char type;
    public Item(int _x, int _height, char _type){
        x = _x;
        height = _height;
        type = _type;
    }
}
