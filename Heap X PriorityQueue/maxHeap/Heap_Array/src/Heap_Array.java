import java.util.ArrayList;

public class Heap_Array {
    static class Heap {
        int[] arr;
        int n;
        Heap(int n) {
            arr = new int[n+1];
            this.n=0;
        }
    }

    static Heap maxHeap = new Heap(12);

    public static void insert(int x) {
        maxHeap.n++;
        maxHeap.arr[maxHeap.n]=x;
        int i= maxHeap.n;
        while(i>1 && maxHeap.arr[i/2]<x) {
            maxHeap.arr[i] = maxHeap.arr[i/2];
            i=i/2;
        }
        maxHeap.arr[i] = x;
    }

    public static int delete() {
        int x = maxHeap.arr[1];
        maxHeap.arr[1] = maxHeap.arr[maxHeap.n];
        maxHeap.n--;
        int i=1, j=2*i;
        while(j<= maxHeap.n) {
            if(maxHeap.arr[j+1]> maxHeap.arr[j]) {
                j = j+1;
            }

            if(maxHeap.arr[i]<maxHeap.arr[j]) {
                int temp = maxHeap.arr[i];
                maxHeap.arr[i] = maxHeap.arr[j];
                maxHeap.arr[j] = temp;

                i=j; j=2*j;
            }
        }
        return x;
    }

    public static void heapSort(ArrayList<Integer> arr) {
        int t = maxHeap.n;
        int i=0;
        while(t>=1) {
//            display();
            int x = delete();
            maxHeap.arr[maxHeap.n+1]=x;
            arr.add(x);
            t--;
        }
    }

    public static void heapSortDisplay(ArrayList<Integer> arr) {
        System.out.println("\nSorted:");          // No Extra Space
        for (int i=1; i<maxHeap.arr.length && maxHeap.arr[i] !=0; i++) {
            System.out.print(maxHeap.arr[i] + " ");
        }

        System.out.println("Elements in Descending Order:");         //ArrayList
        for(Integer x: arr) {
            System.out.print(x + " ");
        }
    }

    public static void display() {
        System.out.println("Displaying Heap...");
        for (int i=1; i<= maxHeap.n; i++) {
            System.out.print(maxHeap.arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(6);
        insert(5);
        insert(25);
        insert(15);
        insert(45);
        insert(35);
        insert(7);
        insert(6);
        insert(78);

        heapSort(arr);
        heapSortDisplay(arr);

//        display();
//
//        delete();
//        delete();
//
//        display();
//
//        arr.clear();
//
//        heapSort(arr);

    }
}
