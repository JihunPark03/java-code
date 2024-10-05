import java.util.Scanner;

class MergeSort {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int y =sc.nextInt();
        int arr[]=new int[y];
        for(int i=0; i<y; i++){  
            arr[i]=sc.nextInt();  
        }  
        MergeSort ob = new MergeSort();
        ob.mergeSort(arr, 0, arr.length);
        sc.close();
    }

  void merge(int arr[], int p, int q, int r) {

    int n1 = q - p;
    int n2 = r - q;

    int L[] = new int[n1];
    int M[] = new int[n2];

    for (int i = 0; i < n1; i++)
      L[i] = arr[p + i];
    for (int j = 0; j < n2; j++)
      M[j] = arr[q + j];

    int i, j, k;
    i = 0;
    j = 0;
    k = p;

    while (i < n1 && j < n2) {
      if (L[i] <= M[j]) {
        arr[k] = L[i];
        i++;
      } else {
        arr[k] = M[j];
        j++;
      }
      k++;
    }

    while (i < n1) {
      arr[k] = L[i];
      i++;
      k++;
    }

    while (j < n2) {
      arr[k] = M[j];
      j++;
      k++;
    }
    printArray(arr);
  }
  void mergeSort(int arr[], int l, int r) {
    if (l < r-1) {
      int m = (l + r) / 2;

      mergeSort(arr, l, m);
      mergeSort(arr, m, r);
      merge(arr, l, m, r);
    }
    

  }

  static void printArray(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n; i++)
      System.out.print(arr[i] + " ");
    System.out.println();
  }  
}


