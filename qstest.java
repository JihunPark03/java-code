import java.util.Arrays;
import java.util.Scanner;

public class qstest {

    public static void mergeSort(int[] array, int inclusiveLeft, int exclusiveRight) {
        if (inclusiveLeft > exclusiveRight) {
            return;
        }

        int mid = (inclusiveLeft + exclusiveRight) / 2;
        mergeSort(array, inclusiveLeft, mid-1);
        mergeSort(array, mid, exclusiveRight-1);

        merge(array, inclusiveLeft, mid-1, exclusiveRight-1);
    }

    private static void merge(int[] array, int inclusiveLeft, int mid, int exclusiveRight) {
        int[] leftArray = Arrays.copyOfRange(array, inclusiveLeft, mid + 1);
        int[] rightArray = Arrays.copyOfRange(array, mid + 1, exclusiveRight);

        int leftIndex = 0;
        int rightIndex = 0;
        int mergedIndex = inclusiveLeft;

        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                array[mergedIndex] = leftArray[leftIndex];
                leftIndex++;
            } else {
                array[mergedIndex] = rightArray[rightIndex];
                rightIndex++;
            }
            mergedIndex++;
        }

        while (leftIndex < leftArray.length) {
            array[mergedIndex] = leftArray[leftIndex];
            leftIndex++;
            mergedIndex++;
        }

        while (rightIndex < rightArray.length) {
            array[mergedIndex] = rightArray[rightIndex];
            rightIndex++;
            mergedIndex++;
        }
        printArray(array);
    }

    public static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y =sc.nextInt();
        int array[]=new int[y];
        for(int i=0; i<y; i++){  
            array[i]=sc.nextInt();  
        }  
        mergeSort(array, 0, y);

        sc.close();
    }
}
