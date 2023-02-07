public class CountSort {

    public static int maxValue(int[] arr) {
        int m=0;
        for (int i=0; i<arr.length; i++) {
            m = Math.max(arr[i], m);
        }
        return m;
    }

    public static void countSort(int[] arr) {
        int idx = maxValue(arr)+1;
        int hash[] = new int[idx];

        for (int i=0; i<arr.length; i++) {
            hash[arr[i]]++;
        }

        int j=0;
        for (int i=0; i<idx; i++) {
            if(hash[i]>0) {
                while(hash[i]!=0) {
                    arr[j++] = i;
                    hash[i]--;
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

        countSort(arr);
        display(arr, 9);
    }
}
