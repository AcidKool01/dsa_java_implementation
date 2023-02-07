public class SelectionSort {
    public static void selectionSort(int[] arr, int n) {
        for (int i=0; i<n; i++) {
            int k=i;
            for (int j=i+1; j<n; j++) {
                if(arr[k]>arr[j]) {
                    k=j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
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

        selectionSort(arr, 9);
        display(arr, 9);
    }
}
