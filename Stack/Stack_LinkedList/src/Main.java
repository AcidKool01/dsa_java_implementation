public class Main {
    static class Stack {
        Stack next;
        int data;

        Stack(int data) {
            this.data=data;
            this.next=null;
        }
    }

    static Stack top = null;

    public static void push(int data) {
        Stack temp = new Stack(data);
        temp.next=top;
        top=temp;
    }

    public static int pop() {
        int x = top.data;
        top=top.next;
        return x;
    }

    public static int peek(int x) {
        return top != null ? top.data : -1;
    }

    public static boolean isEmpty() {
        return top==null;
    }

    public static void display() {
        System.out.println("Displaying Stack...");
        Stack p = top;
        while(p!=null) {
            System.out.print(p.data + " ");
            p=p.next;
        }
    }

    public static void main(String[] args) {
        push(5);
        push(10);
        push(15);
        push(25);
        push(50);
        pop();
        pop();

        display();
    }
}
