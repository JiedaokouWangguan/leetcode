public class Question839{
    boolean tag =false;
    public int numSimilarGroups(String[] A) {
        int[] count = new int[26];
        for(int i = 0;i<A[0].length();i++){
            if(count[A[0].charAt(i) - 'a'] > 0){
                tag = true;
                break;
            }
            count[A[0].charAt(i) - 'a'] += 1;
        }
        
        if(A.length < 2) return A.length;
        int[] group = new int[A.length];
        boolean[] visited = new boolean[A.length];
        for(int i = 0;i<A.length;i++) group[i] = i;
        for(int i = 0;i<A.length;i++) dfs(A, group, visited, i);
        int result = 0;
        for(int i = 0;i<A.length;i++){
            if(group[i] == i)
                result += 1;
        }
        return result;
    }

    private void dfs(String[] A, int[] group, boolean[] visited, int index){
        if(visited[index]) return;
        visited[index] = true;
        for(int i = 0;i<A.length;i++){
            if(visited[i]) continue;
            if(sameGroup(A[index], A[i])){
                group[i] = index;
                dfs(A, group, visited, i);
            }
        }
    }

    private boolean sameGroup(String s1, String s2){
        int res = 0;
        for(int i = 0;i<s1.length();i++){
            if(res >= 3) return false;
            if(s1.charAt(i) != s2.charAt(i)) res += 1;
        }
        return res == 0&&tag || res == 2;
    }
}
