import java.util.ArrayDeque;

class MyQueue{

    int size = 0;
    ArrayDeque<Integer> stack1 = new ArrayDeque<>();
    ArrayDeque<Integer> stack2 = new ArrayDeque<>();
    public MyQueue(){
    
    }

    public void push(int x){
        size += 1;
        if(stack2.size() == 0)
            stack2.push(x);
        else
            stack1.push(x);
    }

    public int pop(){
        size -= 1;
       
        int result = stack2.pop();
        if(stack2.size() == 0 && stack1.size() != 0){
            while(stack1.size() != 0)
                stack2.push(stack1.pop());
        }
        return result;
    }

    public int peek(){
        return stack2.peek();
    }

    public boolean empty(){
        return size == 0;
    }
}
