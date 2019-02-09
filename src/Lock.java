import java.util.*;

public class Lock {
    private Queue<String> queue = new LinkedList<>();
    private HashMap<String, String> visited = new HashMap<>();
    private ArrayList<String> findNeighbors(String node){
        ArrayList<String> neighbors = new ArrayList<>();
        char currentChar;
        for (int i = 0; i < node.length(); i++) {
            currentChar = node.charAt(i);
            char[] chars = node.toCharArray();
            chars[i] = increaseChar(currentChar);
            neighbors.add(String.valueOf(chars));
            chars[i] = decreaseChar(currentChar);
            neighbors.add(String.valueOf(chars));
        }
        return neighbors;
    }

     private char increaseChar(char ch) {
        //int a=Character.getNumericValue(ch);
        //a = (a + 1) % 10;
         if (ch == '9') ch = '0';
            else ch = (char) (ch + 1);
            return ch;
        //return (Integer.toString(a)).charAt(0);

    }

     private char decreaseChar(char ch) {
         if (ch == '0') ch = '9';
            else ch = (char) (ch - 1);
         return ch;
    }

    private int openLock(String[] deadEnd, String root, String target) {
        if (Arrays.asList(deadEnd).contains(root))  return -1;
        int step = 0;
        queue.add(root);
        visited.put(root,"");
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size ; ++i) {
                String current = queue.peek();
                if (current != null && current.equals(target)) {
                    System.out.println(target);
                    printPath(target);
                    return step;
                }
                if (current != null) {
                    for (String next : findNeighbors(current)) {
                        if (!visited.containsKey(next) && (!Arrays.asList(deadEnd).contains(next))){
                            queue.add(next);
                            visited.put(next, current);
                        }
                    }
                }
                queue.remove();
            }
            step = step + 1;
        }
        return -1;
    }

    private void printPath(String target){
        String prev = visited.get(target);
        if (!prev.equals("")) {
            System.out.println(prev);
            printPath(prev);
        }
    }

    public  static void main(String arg[]){
        Lock lock = new Lock();
        String start = "0123";
        String target = "4286";
        String[] deadEnd = new String[]{"1123","4288", "4280", "1000"};
        System.out.println(lock.openLock(deadEnd, start, target));
    }
}
