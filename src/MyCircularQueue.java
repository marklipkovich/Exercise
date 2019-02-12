class MyCircularQueue {
    private int head;
    private int tail;
    int [] queue;
    int k;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    private MyCircularQueue(int k) {
        queue = new int[k];
        head = -1;
        tail = -1;

    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    private boolean enQueue(int value) {
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
    private boolean deQueue() {
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
    private int Front() {
        if (isEmpty())
            return -1;
        else return queue[head];
    }
    /** Get the last item from the queue. */
    private int Rear() {
        if (isEmpty())
            return -1;
        else return queue[tail];
    }
    /** Checks whether the circular queue is empty or not. */
    private boolean isEmpty() {
        return head == -1;
    }
    /** Checks whether the circular queue is full or not. */
    private boolean isFull() {
        int next = tail + 1;
        if (next == queue.length)
            next = 0;
        return next == head;
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

