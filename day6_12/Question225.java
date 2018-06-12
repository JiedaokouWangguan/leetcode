import java.util.ArrayDeque;

class MyStack{
    
    ArrayDeque<Integer> stack1 = new ArrayDeque<>();
    ArrayDeque<Integer> stack2 = new ArrayDeque<>();
    int size = 0;
    int top = -1;
    public MyStack(){
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void push(int x){
        stack1.offer(x);
        top = x;
        size += 1;
    }

    public int pop(){
        while(stack1.size() != 1){
            top = stack1.poll();
            stack2.offer(top);
        }
        ArrayDeque<Integer> tmp = stack1;
        stack1 = stack2;
        stack2 = tmp;
        size -= 1;
        return stack2.pop();
    }

    public int top(){
        return top;
    }

    public boolean empty(){
        return size == 0;
    }

}
