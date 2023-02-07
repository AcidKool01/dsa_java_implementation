public class CircularQueue_List {
    static class Queue {
        int data;
        Queue next;

        Queue(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Queue front=null;
    static Queue rear=null;

    public static boolean isEmpty() {
        return (front == null && rear == null);
    }

    public static void enqueue(int data) {
        Queue temp = new Queue(data);
        if(isEmpty()) {
            rear = front = temp;
        } else {
            rear.next = temp;
            rear=temp;
            rear.next=front;
        }
    }

    public static int dequeue() {
        int x = -1;
        if(isEmpty()) {
            System.out.println("Queue is Empty...");
        } else {
            x = front.data;
            front = front.next;
            rear.next=front;
        }
        return x;
    }

    public static void display() {
        System.out.println("Displaying Queue...");
        for (Queue p = front; p!=rear; p=p.next) {
            System.out.print(p.data + " ");
        }
        System.out.print(rear.data+ " ");
        System.out.println();
    }

    public static void main(String[] args) {
        enqueue(10);
        enqueue(20);
        enqueue(30);
        enqueue(40);
        enqueue(50);
        enqueue(60);

        dequeue();
        dequeue();
        dequeue();
        enqueue(100);

        display();
    }

}
