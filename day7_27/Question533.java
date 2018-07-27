import java.util.HashMap;

public class Question533{
    public int findBlackPixel(char[][] picture, int N) {
        int rows = picture.length;
        int cols = picture[0].length;
        HashMap<String, Integer> map = new HashMap<>();
        int[] count = new int[cols];
        for(int row = 0;row < rows; row++){
            StringBuilder sb = new StringBuilder();
            for(int col = 0;col < cols;col++){
                sb.append(picture[row][col]);
                if(picture[row][col] == 'B') count[col] += 1;
            }
            String curRow = sb.toString();
            map.put(curRow, map.getOrDefault(curRow, 0) + 1);
        }
        int result = 0;
        for(String key : map.keySet()){
            if(map.get(key) != N) continue;
            char[] chars = key.toCharArray();
            int blackCount = 0;
            for(char c : chars)
                if(c == 'B') blackCount += 1;
            if(blackCount != N) continue;
            for(int i = 0;i<chars.length;i++){
                char c = chars[i];
                if(c == 'B'){
                    if(count[i] != N) continue;
                    result += N;
                }
            }
        }
        return result;
    }
}
