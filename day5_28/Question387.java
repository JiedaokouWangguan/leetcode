public class Question387{
    public int firstUniqChar(String s){
        int[] map = new int[128];
        char[] c = s.toCharArray();
        for(char ch : c){
            map[ch] += 1;
        }
        for(int i = 0;i<c.length;i++){
            char ch = c[i];
            if(map[ch] == 1)
                return i;
        }
        return -1;
    }
}
