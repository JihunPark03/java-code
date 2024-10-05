//use counting sort insteead of arrays.sort() for faster sorting

import java.util.Scanner;

class fastsort {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n =sc.nextInt();
    int m =sc.nextInt();
    int i =sc.nextInt();
    int modified[]=fibonaccilist(n,m);

    System.out.println(modified[i - 1]);
    sc.close();
  }

  private static int[] fibonaccilist(int n,int m) {
    int arr[]=new int[n];
    int remainders[]=new int[n];
    arr[0]=0;
    remainders[0]=0;

    for (int i = 1; i < n; i++) {
        arr[i] = (i == 1) ? 1 : (arr[i - 1] + arr[i - 2])%m;
        remainders[i] = arr[i] % m;
    }
    int output[]=countSort(remainders,remainders.length);

    return output;
  }
    private static int [] countSort(int array[], int size) {
      int[] output = new int[size + 1];
  
      int max = array[0];
      for (int i = 1; i < size; i++) {
        if (array[i] > max)
          max = array[i];
      }
      int[] count = new int[max + 1];
  
      for (int i = 0; i < max; ++i) {
        count[i] = 0;
      }
  
      for (int i = 0; i < size; i++) {
        count[array[i]]++;
      }
  
      for (int i = 1; i <= max; i++) {
        count[i] += count[i - 1];
      }
  
      for (int i = size - 1; i >= 0; i--) {
        output[count[array[i]] - 1] = array[i];
        count[array[i]]--;
      }
      for (int i = 0; i < size; i++) {
        array[i] = output[i];
      }
      return array;
    }
}


