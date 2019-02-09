class MyCircularQueue {
    private int head;
    private int tail;
    int [] queue;
    int k;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        queue = new int[k];
        head = -1;
        tail = -1;

    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) return false;
        else {
            tail++;
            if (head == -1) head++;
            if (tail == queue.length) tail = 0;
            queue[tail]=value;
            return true;
        }
    }
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) return false;
        if (head == tail){
            head = -1;
            tail = -1;
            return true;
        }
        else {
            head++;
            if (head == queue.length) head = 0;
            return true;
        }
    }
    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty())
            return -1;
        else return queue[head];
    }
    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty())
            return -1;
        else return queue[tail];
    }
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if (head == -1)
            return true;
        else
            return false;
    }
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        int next = tail + 1;
        if (next == queue.length)
            next = 0;
        if (next == head)
            return true;
        else
            return false;
    }

    public  static void main(String arg[]){
        MyCircularQueue obj = new MyCircularQueue(3);
        System.out.println(obj.enQueue(1));
        System.out.println(obj.enQueue(2));
        System.out.println(obj.enQueue(3));
        System.out.println(obj.enQueue(4));
        System.out.println(obj.Rear());
        System.out.println(obj.isFull());
        System.out.println(obj.deQueue());
        System.out.println(obj.enQueue(4));
        System.out.println(obj.Rear());

    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */