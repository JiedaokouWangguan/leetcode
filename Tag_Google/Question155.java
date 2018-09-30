import java.util.ArrayDeque;

class MinStack {
    // 11.45 - 11.53, 9mins
    ArrayDeque<Element> stack = new ArrayDeque<>();
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        if(stack.size() == 0){
            stack.push(new Element(x, x));
        }
        else{
            int lastMin = stack.peek().tmpMin;
            stack.push(new Element(x, Math.min(x, lastMin)));
        }
    }
    
    public void pop() {
        Element e = stack.pop();
    }
    
    public int top() {
        Element e = stack.peek();
        return e.val;
    }
    
    public int getMin() {
        Element e = stack.peek();
        return e.tmpMin;
    }
}

class Element{
    int val = 0;
    int tmpMin = 0;
    public Element(int _val, int _tmpMin){
        val = _val;
        tmpMin = _tmpMin;
    }
}
