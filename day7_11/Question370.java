public class Question370{
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] oper = new int[length+1];
        for(int[] update : updates){
            int start = update[0];
            int end = update[1];
            int inc = update[2];
            oper[start] += inc;
            oper[end+1] -= inc;
        }
        int[] result = new int[length];
        int op = 0;
        for(int i = 0;i<length;i++){
            op += oper[i];
            result[i] = op;
        }
        return result;
    }
}
