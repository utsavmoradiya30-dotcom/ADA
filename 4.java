import java.util.Random;

public class MergeSortAnalysis {

    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[l + i];
        for (int j = 0; j < n2; j++) R[j] = arr[m + 1 + j];

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void main(String[] args) {
        int size = 10000;
        int[] arr = new int[size];
        Random rand = new Random();

        for (int i = 0; i < size; i++)
            arr[i] = rand.nextInt(100000);

        long start = System.nanoTime();
        mergeSort(arr, 0, size - 1);
        long end = System.nanoTime();

        System.out.println("Time: " + (end - start) / 1e6 + " ms");
    }
}
