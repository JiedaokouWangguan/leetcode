import java.util.HashMap;

public class Question737{
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if(words1.length != words2.length) return false;                                                                                                             
        HashMap<String, Integer> map = new HashMap<>();
        int n = 0;                           
        for(String s : words1){              
            if(!map.containsKey(s))          
                map.put(s, n++);             
        }                                    
        for(String s : words2){              
            if(!map.containsKey(s))          
                map.put(s, n++);             
        }               
        for(String[] pair : pairs){
            String s1 = pair[0];  
            String s2 = pair[1];  
            if(!map.containsKey(s1))                                                                                                                                 
                map.put(s1, n++); 
            if(!map.containsKey(s2))
                map.put(s2, n++); 
        }                  
        int[] union = new int[n];            
        for(int i = 0;i<n;i++)               
            union[i] = i;                    
        for(String[] pair : pairs){          
            String s1 = pair[0];             
            String s2 = pair[1];             
            int i1 = map.get(s1);            
            int i2 = map.get(s2);            
            int r1 = getRoot(i1, union);  
            int r2 = getRoot(i2, union);  
            if(r1 != r2) union[r1] = r2;  
        }                                    
        for(int i = 0;i<words1.length;i++){
            int r1 = getRoot(map.get(words1[i]), union);
            int r2 = getRoot(map.get(words2[i]), union);
            if(r1 != r2) return false;       
        }                                    
        return true;                         
    }                                        

    public int getRoot(int i, int[] union){
        while(i != union[i]){                 
            union[i] = union[union[i]];   
            i = union[i];
        }
        return i;                            
    }
}
