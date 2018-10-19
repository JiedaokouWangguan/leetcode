public class Question277{
    public int findCelebrity(int n) {
        if(n == 1) return 0;
        int cele = 0;
        int index = 1;
        while(index < n){
            if(knows(cele, index) && !knows(index, cele)){
                cele = index;
                index += 1;
            }
            else if(!knows(cele, index) && knows(index, cele)){
                index += 1;
            }
            else{
                cele = index + 1;
                index = index + 2;
            }
        }
        if(cele >= n) return -1;
        for(int i = 0;i<n;i++){
            if(i == cele) continue;
            if(!(knows(i, cele) && !knows(cele, i)))
                return -1;
        }
        return cele;
    }

    boolean knows(int a, int b){
        return false;
    }
}
