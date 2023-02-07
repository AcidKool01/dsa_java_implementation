public class Queue_LinkedList {
    static class Queue {
        int data;
        Queue next;

        Queue (int data) {
            this.data = data;
            this.next=null;
        }
    }

    static Queue front=null;
    static Queue rear=null;

    public static void enqueue(int data) {
        Queue temp = new Queue(data);
        if(rear==null) {
            rear=temp;
            front=temp;
        } else {
            rear.next = temp;
            rear = temp;
        }
    }

    public static int dequeue() {
        int x= -1;
        if(front==null && rear==null) {
            System.out.println("Queue is Empty...");
        } else {
            x = front.data;
            front=front.next;
        }
        return x;
    }

    public static void display() {
        Queue q = front;
        System.out.println("Displaying Queue...");
        do {
            System.out.println(q.data + " ");
            q=q.next;
        } while(q!=null);
    }

    public static void main(String[] args) {
        enqueue(10);
        enqueue(20);
        enqueue(30);
        enqueue(40);
        enqueue(50);

        dequeue();
        dequeue();

        display();
    }
}
