import java.util.Random;

public class QuickSortAnalysis {

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }

        int temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
        return i + 1;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        int size = 10000;
        int[] arr = new int[size];
        Random rand = new Random();

        for (int i = 0; i < size; i++)
            arr[i] = rand.nextInt(100000);

        long start = System.nanoTime();
        quickSort(arr, 0, size - 1);
        long end = System.nanoTime();

        System.out.println("Time: " + (end - start) / 1e6 + " ms");
    }
}
