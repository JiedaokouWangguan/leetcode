import java.util.ArrayDeque;

public class Question909{
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] line = new int[n*n];
        for(int i = 1;i<=n*n;i++){
            int[] tmp = getCordi(i, n);
            line[i-1] = board[tmp[0]][tmp[1]] == -1?-1:board[tmp[0]][tmp[1]]-1;
        }
        int step = 0;
        boolean[] visited = new boolean[n*n];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int start = line[0] == -1?0:line[0];
        queue.offer(start);
        visited[start] = true;
        while(queue.size() > 0){
            int len = queue.size();
            for(int i = 0;i<len;i++){
                int cur = queue.poll();
                if(cur == n*n-1) return step;
                for(int j = 1;j<=6&&cur+j <=n*n-1;j++){
                    int next = cur+j;
                    if(visited[next]) continue;
                    visited[next] = true;
                    next = line[next] == -1?next:line[next];
                    queue.offer(next);
                }
            }
            step += 1;
        }
        return -1;
    }

    private int[] getCordi(int num, int n){
        num -= 1;
        int row = n - 1 - num / n;
        int col = num % n;
        col = row % 2 != n % 2?col:n-1-col;
        return new int[]{row, col};
    }
}
