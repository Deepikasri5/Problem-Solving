//Time Complexity - O(1)
// all the operations O(1)
//exp
// Have a array inside array. 2 hash functions
//1st hash function is to find the modulo 1000
//2nd hash function divide/1000
//create a boolean 2d storage. //only while finding the bucket, if the secondary array is empty, initialize a secondary array in that spot and do 
//put true in that place

class MyHashSet {
    //Double hashing - to avoid the collision
    private boolean[][] storage;
    private int buckets;
    private int bucketItems;

    /** Initialize your data structure here. */
    public MyHashSet() { //In the constructor store how much ever data buckets and bucketItems you need.
            buckets = 1000;
        bucketItems = 1001;
        storage = new boolean[buckets][];
    
    }
    private int bucket(int key){  //hash function for primary storage
        return key%buckets;
    }
    private int bucketItem(int key){ //hash function for secondary storage
        return key/bucketItems;
    }
    
    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null){
            storage[bucket]= new boolean[bucketItems];
        }
        storage[bucket][bucketItem]=true;
    }
    
    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket]==null)return;
        storage[bucket][bucketItem]=false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket]==null) return false;
        return storage[bucket][bucketItem];
    }
}
