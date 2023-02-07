public class LinkedList {
    static class Node {
        public int data;
        public Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head = null;
    public static Node tail = null;

    public static void create(int data) {
        if(head==null) {
            head = new Node(data);
            tail = head;
        } else {
            Node temp = new Node(data);
            tail.next=temp;
            tail = temp;
        }
    }

    public static void delete(int index) {
        Node p = head, q=null;
        index--;
        while(index!=1) {
            p=p.next;
            index--;
        }
        q=p.next;
        p.next=q.next;
    }

    public static void removeDuplicates() {
        Node p = head, q=head;
        while(p!=null) {
            q=p;
            while(q!=null && p.data == q.data) {
                q=q.next;
            }
            p.next=q;
            p=p.next;
        }
    }

    public static void sortList() {
        Node ptr1 = head, ptr2 = null;
        for (; ptr1 != null; ptr1 = ptr1.next) {
            for (ptr2 = ptr1.next; ptr2 != null; ptr2 = ptr2.next) {
                if (ptr1.data > ptr2.data) {
                    int temp = ptr1.data;
                    ptr1.data = ptr2.data;
                    ptr2.data = temp;
                }
            }
        }
    }

    public static void reverse() {
        Node p=head, q=null, r=null;
        tail=head;
        while(p!=null) {
            r=q;
            q=p;
            p=p.next;

            q.next=r;
        }
        head=q;
    }

    public static void display() {
        Node p = head;
        while(p!=null) {
            System.out.print(p.data + " ");
            p=p.next;
        }
    }

    public static void main(String[] Args) {
//        create(10);
//        create(20);
//        create(20);
//        create(30);
//        create(30);
//        create(30);
//        create(40);
//        create(50);
//        create(50);
//        create(50);
//        reverse();
//        display();
//        System.out.println();
//        delete(2);
//        delete(3);
//        removeDuplicates();

        create(40);
        create(70);
        create(30);
        create(60);
        create(20);
        create(10);
        create(80);
        sortList();
        display();
    }
}
