import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static Node root = null;

    public static void create() {
        root = new Node(5);
        Node p = root;

        p.left = new Node(10);
        p.right = new Node(15);

        p.left.left = new Node(20);
        p.left.right = new Node(25);
        p.right.left = new Node(30);
        p.right.right = new Node(35);

        p.left.left.left = new Node(40);
        p.left.left.right = new Node(45);
        p.left.right.left = new Node(50);
        p.left.right.right = new Node(55);
        p.right.left.left = new Node(60);
        p.right.left.right = new Node(65);
        p.right.right.left = new Node(75);
        p.right.right.right = new Node(85);
    }

    public static void preorder(Node p) {
        if(p==null) {
            return;
        }

        System.out.print(p.data + " ");
        preorder(p.left);
        preorder(p.right);
    }

    public static void iterativePreorder(Node p) {
        Stack<Node> st = new Stack<>();
        while(!st.empty() || p!=null) {
            if(p!=null) {
                System.out.print(p.data + " ");
                st.push(p);
                p=p.left;
            } else {
                p=st.pop();
                p=p.right;
            }
        }
    }

    public static void inorder(Node p) {
        if(p==null) {
            return;
        }

        inorder(p.left);
        System.out.print(p.data + " ");
        inorder(p.right);
    }

    public static void iterativeInorder(Node p) {
        Stack<Node> st = new Stack<>();
        while(p!=null || !st.empty()) {
            if(p!=null) {
                st.push(p);
                p=p.left;
            } else {
                p = st.pop();
                System.out.print(p.data + " ");
                p = p.right;
            }
        }
    }

    public static void postorder(Node p) {
        if(p==null) {
            return;
        }

        postorder(p.left);
        postorder(p.right);
        System.out.print(p.data + " ");
    }

    public static void iterativePostorder(Node p) {
        Stack<Node> st = new Stack<>();
        while(!st.isEmpty() || p!=null) {
            while(p!=null) {
                st.push(p);
                st.push(p);
                p=p.left;
            }

            if(st.isEmpty()) return;

            p= st.pop();

            if(!st.isEmpty() && st.peek() == p) {
                p=p.right;
            } else {
                System.out.print(p.data + " ");
                p=null;
            }
        }
    }

    public static void levelOrder(Node p) {
        Queue<Node> q = new LinkedList<>();
        System.out.print(p.data + " ");
        q.add(p);
        while(!q.isEmpty()) {
            p=q.remove();
            if(p.left!=null) {
                System.out.print(p.left.data + " ");
                q.add(p.left);
            }
            if(p.right!=null) {
                System.out.print(p.right.data + " ");
                q.add(p.right);
            }
        }
    }

    public static int height(Node p) {
        if(p==null) {
            return 0;
        }

        int x = height(p.left);
        int y = height(p.right);

        return Math.max(x+1, y+1);
    }

    public static int countNodes(Node p) {
        if (p==null) {
            return 0;
        }

        return countNodes(p.left) + countNodes(p.right) + 1;
    }

    public static int sum(Node p) {
        if(p==null) {
            return 0;
        }

        return p.data + sum(p.left) + sum(p.right);
    }

    public static void main(String[] args) {
        create();
        System.out.println("No. of Nodes: " + countNodes(root));
        System.out.println("Height: " + height(root));
        System.out.println("Sum: " + sum(root));
        System.out.println();

        System.out.println("Preorder:");
        preorder(root);
        System.out.println();
        System.out.println("Iterative PreOrder:");
        iterativePreorder(root);

        System.out.println();
        System.out.println();

        System.out.println("Inorder:");
        inorder(root);
        System.out.println();
        System.out.println("Iterative Inorder:");
        iterativeInorder(root);
        System.out.println();
        System.out.println();

        System.out.println("Postorder:");
        postorder(root);
        System.out.println();
        System.out.println("Iterative PostOrder:");
        iterativePostorder(root);
        System.out.println();
        System.out.println();

        System.out.print("Level Order Traversal:\n");
        levelOrder(root);
    }
}
