import java.util.ArrayList;

public class MyHashSet {


    /** Initialize your data structure here. */
    int n = 100;
    private ArrayList[] mySet = new ArrayList[n];

    private MyHashSet() {
        for (int i = 0; i <n; i++) {
            mySet[i] = new ArrayList();
        }


    }

    private void add(int key) {
        if (!mySet[key % n].contains(key))
            mySet[key % n].add(key);

    }

    private void remove(int key) {

        if (mySet[key % n].size() >0) {
            mySet[key % n].remove(Integer.valueOf(key));
        }
    }

    /** Returns true if this set contains the specified element */
    private boolean contains(int key) {
        if (mySet[key % n].size() >0) {
            return mySet[key % n].contains(key);
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




