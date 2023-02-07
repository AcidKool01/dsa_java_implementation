public class CircularQueue {
    static class Queue {
        int front, rear;
        int[] arr;

        Queue(int n) {
            this.arr = new int[n];
            this.front=-1;
            this.rear=-1;
        }
    }

    static Queue q = new Queue(7);

    public static boolean isFull() {
        return ((q.front==0 && q.rear==q.arr.length-1) || (q.front == q.rear+1));
    }

    public static boolean isEmpty() {
        return (q.front==-1);
    }

    public static void enqueue (int data) {
        if(isFull()) {
            System.out.println("Queue is full...");
        } else {
            if (q.front == -1) {
                q.front = 0;
            }

            q.rear = (q.rear+1)%q.arr.length;
            q.arr[q.rear] = data;
        }
    }

    public static int dequeue () {
        int x = -1;
        if(isEmpty()) {
            System.out.println("Queue is already Empty...");
        } else {
//            x = q.arr[q.front==-1 ? ++q.front : q.front];
            x = q.arr[q.front];

            if(q.front==q.rear) {
                q.front=-1;
                q.rear=-1;
            } else {
                q.front = (q.front+1)%q.arr.length;
            }
        }
        return x;
    }

    public static void display() {
        if(isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println("Displaying Queue...");

        int i;

        for (i=q.front; i!=q.rear; ) {
            System.out.print(q.arr[i] + " ");
            i=(i+1)%q.arr.length;
        }
        System.out.print(q.arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] Args) {
        enqueue(10);
        enqueue(20);
        enqueue(30);
        enqueue(40);
        enqueue(50);
        enqueue(60);
        enqueue(70);
        dequeue();
        dequeue();
        dequeue();

        enqueue(80);
        enqueue(90);

        display();
//
//        dequeue();
//        dequeue();
//
//        display();
    }
}
