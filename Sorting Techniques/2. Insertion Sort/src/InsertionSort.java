public class InsertionSort {
    public static void insertionSort(int[] arr, int n) {
        for (int i=1; i<n; i++) {
            int j=i-1;
            int x = arr[i];

            while(j>=0 && arr[j]>x) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = x;
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

        insertionSort(arr, 9);
        display(arr, 9);
    }
}
