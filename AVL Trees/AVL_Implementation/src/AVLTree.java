public class AVLTree {
    static class Node {
        int data;
        int height;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.height=1;
            this.left = this.right = null;
        }
    }

    static Node root = null;

    // We need function so that we can handle NullPointerException.
    static int getHeight(Node p) {
        return p==null ? 0 : p.height;
    }

    static int balanceFactor(Node p) {
        return p==null ? 0 : getHeight(p.left)-getHeight(p.right);
    }

    public static Node leftRotate(Node p) {
        Node x = p.right;
        Node y = x.left;

        x.left = p;
        p.right = y;

        p.height = Math.max(getHeight(p.left), getHeight(p.right))+1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right))+1;

        return x;
    }

    public static Node rightRotate(Node p) {
        Node x = p.left;
        Node y = x.right;

        x.right = p;
        p.left = y;

        p.height = Math.max(getHeight(p.left), getHeight(p.right))+1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right))+1;

        return x;
    }

    public static Node insert(Node p, int data) {
        // Normal BST Insertion
        if(p==null) {
            return new Node(data);
        }

        if (p.data > data) {
            p.left = insert(p.left, data);
        } else if (p.data < data) {
            p.right = insert(p.right, data);
        } else {
            return p;
        }

        // AVL Rotations
        p.height = 1 + Math.max(getHeight(p.left), getHeight(p.right));
        int balance = balanceFactor(p);

        // Left-Left Unbalanced
        if(balance>1 && data<p.left.data) {
            return rightRotate(p);
        }

        //Right-Right Unbalanced
        if(balance<-1 && data>p.right.data) {
            return leftRotate(p);
        }

        // Left-Right Unbalanced
        if(balance>1 && data>p.left.data) {
            p.left = leftRotate(p.left);
            return rightRotate(p);
        }

        // Right-Left Unbalanced
        if(balance<-1 && data<p.right.data) {
            p.right = rightRotate(p.right);
            return leftRotate(p);
        }

        return p;
    }


    public static Node inorderSuccessor(Node t, int key) {
        Node temp =t;
        while(temp.left!=null) {
            temp=temp.left;
        }
        return temp;
    }

    public static Node deleteNode(Node p, int key) {
        // BST Deletion
        if(p==null) {
            return p;
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

        if(p==null) {
            return p;
        }

        // After Deletion, Balancing...
        p.height = Math.max(getHeight(p.left), getHeight(p.right)) +1;
        int balance = balanceFactor(p);

        // Left-Left Case
        if(balance>1 && balanceFactor(p.left)>=0) {
            return rightRotate(p);
        }

        // Left-Right Case
        if(balance>1 && balanceFactor(p.left)<0) {
            p.left = leftRotate(p.left);
            return rightRotate(p);
        }

        // Right-Right Case
        if(balance<-1 && balanceFactor(p.right)<=0) {
            return leftRotate(p);
        }

        // Right-Left Case
        if(balance<-1 && balanceFactor(p.right)>0) {
            p.right = rightRotate(p.right);
            return leftRotate(p);
        }

        return p;
    }

    public static void inorder(Node p) {
        if(p==null) {
            return;
        }

        inorder(p.left);
        System.out.print(p.data + " ");
        inorder(p.right);
    }

    public static void main(String[] args) {
        // For AVL, Since we rotate Nodes, the root might get changed..so we need to always update it.
        root = new Node(71);
        root = insert(root, 3);
        root = insert(root, 9);
        root = insert(root, 7);
        root = insert(root, 1);
        root = insert(root, 54);
        root = insert(root, 23);
        root = insert(root, 78);
        root = insert(root, 32);

        inorder(root);
        System.out.println();

        root=deleteNode(root, 7);
        root=deleteNode(root, 3);
        root=deleteNode(root, 54);
        root=deleteNode(root, 78);
        root=deleteNode(root, 32);
        inorder(root);
    }
}
