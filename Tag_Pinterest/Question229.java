import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Question229{
    
    public List<Integer> majorityElement(int[] nums) {
        int i1 = 0;
        int i2 = 1;
        int count1 = 0;
        int count2 = 0;
        for(int num : nums){
            if(i1 == num){
                count1 += 1;
            }
            else if(i2 == num){
                count2 += 1;
            }
            else if(count1 == 0){
                i1 = num;
                count1 = 1;
            }
            else if(count2 == 0){
                i2 = num;
                count2 = 1;
            }
            else{
                count1 -= 1;
                count2 -= 1;
            }
        }
        count1 = 0;
        count2 = 0;
        List<Integer> result = new ArrayList<>();
        for(int num : nums){
            if(num == i1) count1 += 1;
            if(num == i2) count2 += 1;
        }
        if(count1 > nums.length/3) result.add(i1);
        if(count2 > nums.length/3) result.add(i2);
        return result;
    }

    public List<Integer> majorityElementK(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int size = 0;
        for(int num : nums){
            if(map.containsKey(num) && map.get(num) != 0){
                map.put(num, map.get(num)+1);
            }            
            else{        
                if(size == 2){
                    for(Integer key : map.keySet()){
                        if(map.get(key) != 0){
                            map.put(key, map.get(key)-1);
                            if(map.get(key) == 0) size -= 1;
                        }
                    }   
                }        
                else{ 
                    size += 1;
                    map.put(num, 1); 
                }        
            }            
        }                
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num) && map.get(num) != 0) map1.put(num, map1.getOrDefault(num, 0)+1);
        }                
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        for(Integer key : map1.keySet()){
            if(map1.get(key) > (n/3)) result.add(key);
        }                
        return result;                                                                                      
    }
}
