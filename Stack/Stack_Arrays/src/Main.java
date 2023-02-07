public class Main {
    static class Stack {
        int[] s;
        int top;

        Stack(int n) {
            this.s=new int[n];
            this.top=-1;
        }
    }

    static Stack st = new Stack(5);

    public static void push(int x) {
        if(st.s.length-1==st.top) {
            System.out.println("Stack Overflow...");
        } else {
            st.top++;
            st.s[st.top] = x;
        }
    }

    public static int pop() {
        int x=-1;
        if(st.top==-1) {
            System.out.println("Stack Underflow...");
        } else {
            x = st.s[st.top];
            st.top--;
        }

        return x;
    }

    public static boolean peek(int x) {
        for(int i=st.top; i>=0; i--) {
            if(st.s[i]==x) {
                System.out.println("Found.");
                return true;
            }
        }
        System.out.println("Not Found.");
        return false;
    }

    public static boolean isEmpty() {
        return st.top==-1;
    }

    public static boolean isFull() {
        return st.top==st.s.length;
    }

    public static void display() {
        System.out.println("Displaying Stack...");
        for (int i= st.top; i>=0; i--) {
            System.out.print(st.s[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        push(5);
        push(10);
        push(15);
        push(20);
        display();

        pop();
        pop();
        push(40);
        peek(5);
        peek(90);

        display();
    }
}

