public class Question277{
    // 3.55 - 4.04, 10mins
    public int findCelebrity(int n) {
        int cele = 0;
        int i = 1;
        while(i<n){
            boolean cki = knows(cele, i);
            boolean ikc = knows(i, cele);
            if(cki&&ikc || !cki && !ikc){
                cele = i+1;
                i = cele+1;
            }
            else if(!ikc){
                cele = i;
                i = cele+1;
            }
            else{
                i += 1;
            }
        }
        if(cele >= n) return -1;
        for(i = 0;i<n;i++){
            if(i == cele) continue;
            if(knows(cele, i) || !knows(i, cele)) return -1;
        }
        return cele;
    }

    boolean knows(int a, int b){
        return false;
    }
}
