import java.util.ArrayList;
import java.util.Collections;

// Most Efficient Sorting for Floating Values b/w 0 & 1.

public class BucketBinSort {
    public static void bucketBinSort(float[] arr) {
        ArrayList<Float>[] bucket = new ArrayList[arr.length];
        for (int i=0; i<arr.length; i++) {
            bucket[i] = new ArrayList<Float>();
        }
        for (int i=0; i<arr.length; i++) {
            int j = (int) arr[i]*arr.length;
            bucket[j].add(arr[i]);
        }

        for (int i=0; i<arr.length; i++) {
            Collections.sort(bucket[i]);
        }

        int j=0;

        for (int i=0; i<bucket.length; i++) {
            for (Float x: bucket[i]) {
                arr[j++] = x;
            }
        }
    }

    public static void display(float[] arr, int n) {
        System.out.println("Sorted Array is:");
        for (int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] Args) {
        float[] arr = new float[]{(float)0.41, (float)0.31, (float)0.61, (float)0.32, (float)0.75, (float)0.71
                                  ,(float)0.82, (float)0.71, (float)0.34};

        bucketBinSort(arr);
        display(arr, 9);
    }
}
