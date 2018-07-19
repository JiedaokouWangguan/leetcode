class MyHashMap {

    private class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    } 

    private Node[] list = new Node[1000000];

    public MyHashMap() {

    }

    private Node getNode(int index) {
        Node node = list[index];
        if (node == null) return null;
        while (node.next != null) node = node.next;
        return node;
    }

    public void put(int key, int value) {
        int hashcode = key % 1000000;
        Node node = getNode(hashcode);
        if (node == null) {
            Node keyNode = new Node(key, value);
            list[hashcode] = keyNode;
        } else {
            Node keyNode = new Node(key, value);
            Node listNode = list[hashcode];
            while (listNode != null) {
                if (listNode.key == key) {
                    listNode.value = value;
                    return;
                }
            }
            keyNode.prev = node;
            node.next = keyNode;
        }
    }

    public int get(int key) {
        int index = key % 1000000;
        Node node = list[index];
        if (node == null) return -1;
        Node curr = node;
        while (curr != null) {
            if (curr.key == key) return curr.value;
            curr = curr.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = key % 1000000;
        Node node = list[index];
        if (node == null) return;
        Node curr = node;
        if (node.next == null && node.prev == null) {
            list[index] = null;
            return;
        }
        while (curr != null) {
            if (curr.key == key) {
                Node prev = curr.prev;
                Node next = curr.next;
                if (prev != null)prev.next = next;
                if (next != null)next.prev = prev;
            }
            curr = curr.next;
        }
    }
}
