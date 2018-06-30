public class Question517{
    public int findMinMoves(int[] machines) {
        int total = 0;                 
        for(int i: machines) total+=i;
        if(total%machines.length!=0) return -1; 
        int avg = total/machines.length;
        int sum = 0;                   
        int min = 0;                   
        int cnt = 0;                   
        for(int i = 0;i < machines.length;i++){
            int load = machines[i]; 
            sum += load;               
            int rcnt = (i+1) * avg - sum;
            if(cnt >= 0 && rcnt >= 0)
                min = Math.max(min, Math.max(cnt, rcnt));                                                            
            else if(cnt <= 0 && rcnt <= 0)
                min = Math.max(min, -cnt-rcnt);
            else{                      
                min = Math.max(min, Math.max(Math.abs(cnt), Math.abs(rcnt)));
            }                          
            cnt = -rcnt;                
        }                              
        return min;                    
    }
}
