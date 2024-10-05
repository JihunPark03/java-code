import java.util.Arrays;

public class QuickSortWithMedianOfThree {

    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = findPivotIndex(array, left, right);
            int pivot = array[pivotIndex];
            swap(array, left, pivotIndex);

            int i = left + 1;
            int j = right - 1;

            while (i < j) {
                while (array[i] < pivot) {
                    i++;
                }

                while (array[j] > pivot) {
                    j--;
                }

                if (i < j) {
                    swap(array, i, j);
                    i++;
                    j--;
                }
            }

            quickSort(array, left, j);
            quickSort(array, j + 1, right);
        }
    }

    private static int findPivotIndex(int[] array, int left, int right) {
        int middle = left + (right - left) / 2;
        int[] pivotCandidates = {array[left], array[middle], array[right]};
        Arrays.sort(pivotCandidates);
        return Arrays.binarySearch(pivotCandidates, array[middle]);
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 4, 1, 3};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
