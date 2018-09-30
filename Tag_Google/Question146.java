import java.util.HashMap;

class LRUCache {
    // 10.54 - 11.08, 14mins
    
    HashMap<Integer, Node> map = new HashMap<>();
    int cap = 0;
    int size = 0;
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);

    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node n = map.get(key);
        removeNode(n);
        addNode(n);
        return n.value;
    }
    
    public void put(int key, int value) {
        if(cap == 0) return;
        Node n = null;
        if(map.containsKey(key)){
            n = map.get(key);
            n.value = value;
            removeNode(n);
        }
        else{
            if(size == cap){
                size -= 1;
                Node tmp = tail.prev;
                map.remove(tmp.key);
                removeNode(tmp);
            }
            size += 1;
            n = new Node(key, value);
        }
        map.put(key, n);
        addNode(n);
    }

    private void removeNode(Node n){
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    private void addNode(Node n){
        n.next = head.next;
        head.next.prev = n;
        n.prev = head;
        head.next = n;
    }
}

class Node{
    Node prev = null;
    Node next = null;
    int key = 0;
    int value = 0;
    public Node(int _key, int _value){
        key = _key;
        value = _value;
    }
}

