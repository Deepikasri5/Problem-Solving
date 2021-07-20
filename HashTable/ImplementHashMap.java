// We are going to implement Linear chaining,  we will have a primary array and linkedlist, each block of primary array contains a node head which is a linkedlist. O(1) operations
class MyHashMap {
    class Node{
    int key;
    int val;
    Node next;
    public Node(int key,int val){
        this.key=key;
        this.val=val;
    }
}

    public Node[] storage;
    /** Initialize your data structure here. */
    
    public MyHashMap() {
        storage = new Node[10000];
    }
    public int hash(int key){
        return Integer.hashCode(key) % storage.length;
    }
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int primaryIndex = hash(key);
        if(storage[primaryIndex]==null){
            storage[primaryIndex]=new Node(-1,-1);
        }
        Node prev=find(storage[primaryIndex],key);
        if(prev.next==null){
            prev.next=new Node(key,value);
            return;}
        else{
            prev.next.val=value;
        }
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = hash(key);
        if(storage[index]==null) return -1;
        Node prev=find(storage[index],key);
        if(prev.next==null) {return -1;}
        else if(prev.next!=null){
            return prev.next.val;
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index=hash(key);
        if(storage[index]==null) return;
        Node prev=find(storage[index],key);
        if(prev.next==null)return;
        prev.next=prev.next.next;
    }
    public Node find(Node head,int key){
        Node prev=null;
        Node curr=head;
        while(curr!=null && curr.key!=key){
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }
}