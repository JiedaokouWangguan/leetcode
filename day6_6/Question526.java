public class Question526{
    
    int count = 0;
    
    public int countArrangement(int N){
        backtrack(N, new boolean[N+1], 1);
        return count;
    }

    private void backtrack(int N, boolean[] visited, int index){
        if(index > N)
            count += 1;
        for(int i = 1;i<visited.length;i++){
            if(!visited[i]){
                if(i % index == 0 || index % i == 0){
                    visited[i] = true;
                    backtrack(N, visited,index+1);
                    visited[i] = false;
                }
            }
        }
    }
}
