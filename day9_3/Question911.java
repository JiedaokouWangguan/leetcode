import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Comparator;

class TopVotedCandidate {
    // 10.59 - 

    PriorityQueue<int[]> pq = null;               
    TreeMap<Integer, Integer> winner = null;      
    HashMap<Integer, int[]> map = null;           
    public TopVotedCandidate(int[] persons, int[] times) {
        pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] i1, int[] i2){
                if(i1[1] == i2[1]) return i2[2] - i1[2];
                else return i2[1] - i1[1];                                                                                 
            }        
        });          
        winner = new TreeMap<>();                 
        map = new HashMap<>();   
        int counter = 0;     
        for(int i = 0;i<persons.length;i++){      
            int person = persons[i];              
            int time = times[i];                     
            if(!map.containsKey(person)){         
                int[] p = new int[]{person, 1, counter++};
                map.put(person, p);               
                pq.offer(p);                      
            }        
            else{    
                int[] p = map.get(person);        
                pq.remove(p);                     
                p[1] += 1; 
                p[2] = counter++;
                pq.offer(p);                      
            }        
            winner.put(time, pq.peek()[0]);       
        }            
    }                

    public int q(int t) {                         
        int key = winner.floorKey(t);             
        return winner.get(key);                   
    }                
}
