import java.util.ArrayList;

public class Question390{
    public int lastRemaining(int n){
        int remaining = n;
        int step = 1;
        int head = 1;
        boolean left2right = true;
        while(remaining > 1){
            if(left2right || remaining % 2 == 1){
                head += step;
            }
            remaining /= 2;
            step *= 2;
            left2right = !left2right;
        }
        return head;
    }
}
