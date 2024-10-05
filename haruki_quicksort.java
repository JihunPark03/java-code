import java.util.Scanner;
import java.util.Arrays;

public class quicksort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int num[] = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = scanner.nextInt();
        }
        quickSort(num, 0, N - 1);

        scanner.close();
    }

    static void quickSort(int a[], int l, int r) {
        if (l < r) {
            int pivot = getMedian(a, l, r);
            int i = l;
            int j = r;

            while (true) {
                while (a[i] < pivot) {
                    i++;
                }
                while (j >= 0 && a[j] > pivot) { 
                    j--;
                }

                if (i <= j) {
                    swap(a, i, j);
                    i++;
                    j--;
                } else {
                    break;
                }
            }

            for (int k = 0; k < a.length; k++){
                System.out.print(a[k] + " ");
            }

            System.out.println();

            quickSort(a, l, j);
            quickSort(a, i, r);
        }
    }

    static int getMedian(int[] a, int l, int r) {
        int m = (l + r) / 2;
        int[] nums = {a[l], a[m], a[r]};
        Arrays.sort(nums);
        int median = nums[1];
        return median;
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}