public class Queue_Array {
    static class Queue {
        int front, rear;
        int[] arr;

        Queue(int n) {
            this.arr = new int[n];
            this.front=0;
            this.rear=-1;
        }
    }

    static Queue q = new Queue(7);

    public static void enqueue (int data) {
        if(q.rear==q.arr.length-1) {
            System.out.println("Queue is full...");
        } else {
            q.rear++;
            q.arr[q.rear] = data;
        }
    }

    public static int dequeue () {
        int x = -1;
        if(q.front==q.rear) {
            System.out.println("Queue is already Empty...");
        } else {
//            x = q.arr[q.front==-1 ? ++q.front : q.front];
            x = q.arr[q.front];
            q.front++;
        }
        return x;
    }

    public static boolean isEmpty() {
        return q.rear==q.front;
    }

    public static boolean isFull() {
        return q.rear==q.arr.length-1;
    }

    public static void display() {
        System.out.println("Displaying Queue...");
//        for (int i= q.front==-1 ? 0 : q.front; i<=q.rear; i++) {
        for (int i=q.front; i<=q.rear; i++) {
            System.out.print(q.arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] Args) {
        enqueue(10);
        enqueue(20);
        enqueue(30);
        enqueue(40);
        enqueue(50);

        display();

        dequeue();
        dequeue();

        display();
    }
}
