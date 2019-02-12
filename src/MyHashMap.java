import java.util.ArrayList;

class MyHashMap {
    /** Initialize your data structure here. */
    int n = 1000;
    ArrayList[] mySet = new ArrayList[n];
    ArrayList listHash;

    public MyHashMap() {
        for (int i = 0; i <n; i++)
            mySet[i] = new ArrayList();
    }

    public void put(int key, int value) {
        if (have (key) == -1)
            listHash.add(new int[] {key, value});
        else
        ((int[]) listHash.get(have (key)))[1] =value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if (have (key) >= 0)
            return ((int[])listHash.get(have (key)))[1];
        else
            return -1;
    }

    public int have(int key) {
         listHash = mySet[key % n];
            for (int i = 0; i < listHash.size(); i++) {
                int k =  ((int[]) listHash.get(i))[0];
                if (k==key) {
                    return i;
                }
            }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
            if (have (key) >= 0)
                listHash.remove(have (key));
    }

    public  static void main(String arg[]){

        MyHashMap obj = new MyHashMap();
        obj.put(1005, 5);
        obj.put(1005, 6);
        obj.put(1004, 7);

        obj.remove(1005);

        obj.remove(1004);
        obj.put(1004, 1);
        obj.put(1005, 5);
        //obj.remove(1005);
        //obj.remove(1004);
        obj.put(1005, 5);
        obj.put(2005, 10);
        obj.put(4005, 15);
        //obj.remove(1005);

        System.out.println(obj.get(1005));
        System.out.println(obj.get(1004));
        System.out.println(obj.get(1003));

        //obj.add(1005);
        //obj.add(1005);
        //obj.remove(1002);
        //System.out.println(obj.contains(1001));
        //System.out.println(obj.contains(1002));
    }
}
