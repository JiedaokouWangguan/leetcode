import java.util.HashMap;

class LRUCache {
    int cap = 0;
    int size = 0;
    DLLNode recent = new DLLNode(0, 0);
    DLLNode notRecent = new DLLNode(0, 0);
    HashMap<Integer, DLLNode> map = new HashMap<>();
    public LRUCache(int capacity) {
        recent.next = notRecent;
        notRecent.prev = recent;
        cap = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        DLLNode node = map.get(key);
        deleteNode(node);
        addNode(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            DLLNode node = map.get(key);
            node.value = value;
            deleteNode(node);
            addNode(node);
        }
        else{
            if(size == cap){
                size -= 1;
                DLLNode tmp = notRecent.prev;
                deleteNode(tmp);
            }
            size += 1;
            DLLNode node = new DLLNode(key, value);
            addNode(node);
        }
    }

    private void deleteNode(DLLNode node){
        map.remove(node.key);
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void addNode(DLLNode node){
        map.put(node.key, node);
        node.next = recent.next;
        recent.next.prev = node;
        node.prev = recent;
        recent.next = node;
    }
}

class DLLNode{
    int key;
    int value;
    DLLNode prev = null;
    DLLNode next = null;
    public DLLNode(int key, int value){
        this.value = value;
    }
}
