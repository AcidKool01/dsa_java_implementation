import java.util.ArrayList;
import java.util.Collections;

public class RadixSort {

    public static int highestPlace(int[] arr){
        int p=0;
        for (int i=0; i<arr.length; i++) {
            int x = arr[i];
            int temp=0;
            while(x>0) {
                x=x/10;
                temp++;
            }
            p = Math.max(temp, p);
        }
        return p;
    }

    public static void radixSort(int[] arr) {
        ArrayList<Integer>[] bins= new ArrayList[11];

        int k = highestPlace(arr);
        for (int i=0; i<11; i++) {
            bins[i] = new ArrayList<>();
        }
        int l=1;
        while(k!=0) {
            for (int i=0; i<arr.length; i++) {
                int j = (int) (arr[i] % Math.pow(10, l));
                bins[j].add(arr[i]);
            }

            for (int i=0; i<arr.length; i++) {
                Collections.sort(bins[i]);
            }
            k--; l++;
        }

        int j=0;
        for (int i=0; i<bins.length; i++) {
            for (Integer x: bins[i]) {
                arr[j++] = x;
            }
        }

    }

    public static void display(int[] arr, int n) {
        System.out.println("Sorted Array is:");
        for (int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] Args) {
        int[] arr = new int[]{4,2,7,8,1,6,4,10,5};

        radixSort(arr);
        display(arr, 9);
    }
}
