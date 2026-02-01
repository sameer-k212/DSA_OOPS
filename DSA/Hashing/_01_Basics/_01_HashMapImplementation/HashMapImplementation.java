package DSA.Hashing._01_Basics._01_HashMapImplementation;

public class HashMapImplementation {
    class Node {
        String key;
        Integer value;
        Node next;
    }

    private Node[] bucket;
    private int size;

    public HashMapImplementation(int n) {
        bucket = new Node[n];
    }

    public int hashFunc(String key) {
        int idx = key.hashCode() % bucket.length;
        if (idx < 0) {
            idx += bucket.length;
        }
        return idx;
    }

    public void put(String key, Integer value) {
        int bn = hashFunc(key);
        Node temp = bucket[bn];
        while (temp != null) {
            if (temp.key.equals(key)) {
                temp.value = value;
                return;
            }
            temp = temp.next;
        }
        Node nn = new Node();
        nn.value = value;
        nn.key = key;
        nn.next = bucket[bn];
        bucket[bn] = nn;
        size++;
    }

    public Integer get(String key) {
        int bn = hashFunc(key);
        Node temp = bucket[bn];
        while (temp != null) {
            if (temp.key.equals(key)) {
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }

    public Boolean containsKey(String key) {
        int bn = hashFunc(key);
        Node temp = bucket[bn];
        while (temp != null) {
            if (temp.key.equals(key)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public static void main(String[] args) {
        HashMapImplementation map = new HashMapImplementation(10);
        map.put("key1", 10);
        map.put("key2", 1);
        map.put("key3", 32);
        map.put("key5", 5);

        System.out.println(map.get("key1")); // 10
        System.out.println(map.containsKey("key3")); // true
    }
}
