public class Question605{
    public boolean canPlaceFlowers(int[] flowerbed, int n){ 
        if(flowerbed == null || flowerbed.length == 0)
            return false;
        if(flowerbed.length == 1)
            return (flowerbed[0] == 0 && n == 1) || n == 0;
        int last = -1; 
        for(int i = 0;i<flowerbed.length;i++){
            if(n == 0)
                break;
            if(flowerbed[i] == 0){ 
                if(i == 0 && flowerbed[1] == 0){ 
                    n -= 1;
                    last = i;
                }        
                else if(i == flowerbed.length-1 && last < flowerbed.length-2){
                    n -= 1;
                    last = i;
                }        
                else if(i != 0 && i != flowerbed.length-1 && flowerbed[i+1] == 0 && last < i-1){
                    n -= 1;
                    last = i;
                }        
            }            
            else{        
                last = i;
            }            
        }                
        return n == 0;
    }
}
