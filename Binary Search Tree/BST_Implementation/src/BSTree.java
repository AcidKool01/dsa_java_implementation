import java.util.ArrayList;

public class BSTree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static Node root=null;

    public static void insert(Node p, int data) {
        Node q =null;
        if(root==null) {
            root=new Node(data);
            return;
        }
        while(p!=null) {
            q=p;
            if(p.data>data) {
                p=p.left;
            } else {
                p=p.right;
            }
        }

        if(q.data>data) {
            q.left = new Node(data);
        } else if(q.data<data) {
            q.right = new Node(data);
        }
    }

    public static Node insertRec(Node p, int data) {
        Node t=null;
        if(p==null) {
            t=new Node(data);
            return t;
        }

        if(p.data>data) {
            p.left = insertRec(p.left, data);
        } else if(p.data<data) {
            p.right = insertRec(p.right,data);
        }

        return p;
    }

    public static boolean search(Node p, int key) {
        while(p!=null) {
            if(p.data>key) {
                p=p.left;
            } else if(p.data<key) {
                p=p.right;
            } else {
                System.out.println("Key Found.");
                return true;
            }
        }
        System.out.println("Key Not Found.");
        return false;
    }

    public static Node inorderSuccessor(Node t, int key) {
        Node temp =t;
        while(temp.left!=null) {
            temp=temp.left;
        }
        return temp;
    }

    public static Node deleteNode(Node p, int key) {
        if(p==null) {
            return null;
        }

        if(p.data>key) {
            p.left=deleteNode(p.left, key);
        } else if(p.data<key) {
            p.right=deleteNode(p.right, key);
        } else {
            if(p.left==null && p.right==null) {
                p=null;
            } else if(p.left==null && p.right!=null) {
                p=p.right;
            } else if(p.left!=null && p.right==null) {
                p=p.left;
            } else if(p.left!=null && p.right!=null) {
                Node temp = inorderSuccessor(p.right, p.data);
                p.data = temp.data;
                p.right = deleteNode(p.right, temp.data);
            }
        }

        return p;
    }

    public static void inorder(ArrayList<Integer> arr, Node p) {
        if(p==null) {
            return;
        }

        inorder(arr, p.left);
        arr.add(p.data);
        inorder(arr, p.right);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        root = new Node(5);
        insertRec(root, 2);
        insertRec(root, 7);
        insertRec(root, 1);
        insertRec(root, 3);
        insertRec(root, 9);
        insertRec(root, 10);
        insertRec(root, 8);

        deleteNode(root, 1);
        deleteNode(root, 2);
        deleteNode(root, 3);
        deleteNode(root, 9);
        deleteNode(root, 10);
//        deleteNode(root, 1);

        inorder(arr, root);
        System.out.println("Displaying ArrayList");
        for (Integer x : arr) {
            System.out.print(x + " ");
        }


    }
}
