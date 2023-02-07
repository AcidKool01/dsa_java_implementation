
// ** 1. WITHOUT LAZY PROPAGATION **
class SegmentTree {
    int[] tree;
    SegmentTree(int n) {
        this.tree = new int[n];
    }

    void build(int[] arr, int node, int start, int end) {
        if(start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start+end)/2;
            build(arr, 2*node+1, start, mid);
            build(arr, 2*node+2, mid+1, end);
            tree[node] = tree[2*node+1] + tree[2*node+2];
        }
    }

    int query(int node, int start, int end, int left, int right) {
        if(start > right || end < left) {
            return 0;
        } else if(start >= left && end <= right) {
            return tree[node];
        } else {
            int mid = (start + end)/2;
            int q1 = query(2*node+1, start, mid, left, right);
            int q2 = query(2*node+2, mid+1, end, left, right);

            return q1+q2;
        }
    }

    void update(int[] arr, int node, int index, int val, int start, int end) {
        if(start == end){
            arr[index] += val;
            tree[node] += val;
        }
        else{
            int mid = (start + end)/2;
            if(start <= index && index <= mid){
                update(arr, 2*node+1, index, val, start, mid);
            }
            else{
                update(arr, 2*node+2, index, val, mid + 1, end);
            }
            tree[node] = tree[2*node+1] + tree[2*node+2];
        }
    }
}

// ** 2. LAZY PROPAGATION **

public class Main {
    public static void main(String[] args) {
        int[] arr = {2, 3, -1, 5, -2, 4, 8, 10};
        int n = arr.length;
        int height = (int)( Math.log(n)/Math.log(2) )+ 1;
        int tree_nodes = (int) Math.pow(2, height+1);

        SegmentTree st = new SegmentTree(tree_nodes);
        st.build(arr, 0, 0, n-1);

        /*
        // Print segmentTree() :
            for(int i=0; i<tree_nodes; i++) {
                System.out.print(st.tree[i] + " ");
            }
            System.out.println();
        */

        System.out.println(st.query(0, 0, n-1, 0, 7));
        System.out.println(st.query(0, 0, n-1, 0, 1));
        System.out.println(st.query(0, 0, n-1, 2, 5));
        System.out.println(st.query(0, 0, n-1, 1, 3));

        st.update(arr, 0, 2, 10, 0, n-1);

        /*
        // Print segmentTree() :
            for(int i=0; i<tree_nodes; i++) {
                System.out.print(st.tree[i] + " ");
            }
            System.out.println();
        */

        System.out.println("\n\n After Update : ");
        System.out.println(st.query(0, 0, n-1, 0, 7));
        System.out.println(st.query(0, 0, n-1, 0, 1));
        System.out.println(st.query(0, 0, n-1, 2, 5));
        System.out.println(st.query(0, 0, n-1, 1, 3));
    }
}