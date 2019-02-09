import java.util.ArrayList;

public class MyHashSet {


    /** Initialize your data structure here. */
    int n = 100;
    ArrayList[] mySet = new ArrayList[n];

    public MyHashSet() {
        for (int i = 0; i <n; i++)
            mySet[i] = new ArrayList();


    }

    public void add(int key) {
        if (!mySet[key % n].contains(key))
            mySet[key % n].add(key);

    }

    public void remove(int key) {

        if (mySet[key % n].size() >0) {
            mySet[key % n].remove(Integer.valueOf(key));
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if (mySet[key % n].size() >0) {
            if (mySet[key % n].contains(key)) {
                return true;
            }
        }
        return false;
    }

    public  static void main(String arg[]){

        MyHashSet obj = new MyHashSet();

        obj.add(1002);
        obj.add(1005);
        obj.add(1005);
        obj.remove(1002);
        System.out.println(obj.contains(1001));
        System.out.println(obj.contains(1002));
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */


