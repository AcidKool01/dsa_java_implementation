public class QuickSort {

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low-1;

        for (int j=low; j<high; j++) {
            if(arr[j]<=pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if(low<high) {
            int p = partition(arr, low, high);

            quickSort(arr, low, p-1);
            quickSort(arr, p+1, high);
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

        quickSort(arr,0,8);    //n-1
        display(arr, 9);
    }
}
