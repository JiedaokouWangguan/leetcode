class RLEIterator {
    Integer curNum = null;
    int curCount = 0;
    int index = -2;
    int[] A = null;
    public RLEIterator(int[] A) {
        this.A = A;
    }

    public int next(int n) {
        while(curCount == 0){
            if(index+2 >= A.length) return -1;
            index += 2;
            curCount = A[index];
            curNum = A[index+1];
        }
        if (curCount >= n){
            curCount -= n;
            return curNum;
        }
        else{
            int tmp = curCount;
            curCount = 0;
            return next(n - tmp);
        }
    }
}
