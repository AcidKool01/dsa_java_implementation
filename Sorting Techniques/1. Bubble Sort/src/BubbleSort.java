public class BubbleSort {

    public static void bubbleSort(int[] arr, int n) {
        int flag=0;                             // If flag==0, Already Sorted...Best Case==O(n)
        for(int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++){
                if(arr[j]<arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    flag=1;
                }
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

        bubbleSort(arr, 9);
        display(arr, 9);
    }
}
