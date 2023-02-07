public class MergeSort {

    public static void merge (int[] arr, int low, int mid, int high) {
        int i, j, k;
        i=low; j=mid+1; k=low;

        int[] B = new int[100];

        while(i<=mid && j<=high) {
            if(arr[i]>arr[j]) {
                B[k++] = arr[j++];
            } else{
                B[k++] = arr[i++];
            }
        }

        for (; i<=mid; i++) {
            B[k++] = arr[i];
        }

        for (; j<=high; j++) {
            B[k++] = arr[j];
        }

        for (i=low; i<=high; i++) {
            arr[i] = B[i];
//            System.out.print(arr[i] + " ");
        }
//        System.out.println();
    }

    public static void mergeSort(int[] arr, int l, int h) {
        if(l<h) {
            int mid = (l+h)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, h);

            merge(arr, l, mid, h);
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

        mergeSort(arr, 0, 8);
        display(arr, 9);
    }
}
