import java.util.ArrayDeque;

public class Question42{
    public int trap(int[] height){
        int result = 0;
        ArrayDeque<Wall> stack = new ArrayDeque<>();
        for(int i = 0;i<height.length;i++){
            if(stack.size() == 0 || height[i] <= stack.peek().height){
                stack.push(new Wall(i, height[i]));
            }
            else{
                while(stack.size() != 0 && stack.peek().height < height[i]){
                    
                }
            }
            
        }
    }
}

class Wall{
    int index;
    int height;
    public Wall(int i, int h){
        index = i;
        height = h;
    } 
}
