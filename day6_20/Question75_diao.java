public class Question75_diao{
    public void sortColors(int[] A, int n){
        int j = 0;
        int k = n-1;
        for(int i = 0;i<=k ;i++){
            if(A[i] == 0){
                swap(A, i, j++);
            }
            else if(A[i] == 2){
                swap(A, i--, k--);
            }
        }
    }

    private void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
