import java.util.Arrays;
import java.util.Scanner;

public class quicksort {

    public static void quickSort(int[] array, int left, int right) {
        if (left < right){
            int pivot = median(array, left, right);
            int i = left;
            int j = right;
            while (true) {
                while (array[i] < pivot) {
                    i++;
                }
                while (j >= 0 &&array[j] > pivot) {
                    j--;
                }
                if (i <= j) {
                    swap(array, i, j);
                    i++;
                    j--;
                }
                else{
                    break;
                }
            }
            for (int k = 0; k < array.length; k++){
                System.out.print(array[k] + " ");
            }
            System.out.println();
            quickSort(array, left, j);
            quickSort(array, i, right);
        }
    }

    private static int median(int[] array, int left, int right) {
        int middle = left + (right - left) / 2;
        int[] li = {array[left], array[middle], array[right]};
        Arrays.sort(li);

        return li[1];
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y =sc.nextInt();
        int array[]=new int[y];
        for(int i=0; i<y; i++){  
            array[i]=sc.nextInt();  
        }  
        quickSort(array, 0, y-1);
        sc.close();
    }
}
