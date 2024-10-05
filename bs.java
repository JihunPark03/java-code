import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class bs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y =sc.nextInt();
        int arr []=new int[y];
        for(int i=0; i<y; i++){  
        arr[i]=sc.nextInt();  
        }  
        int key =sc.nextInt();
        binarySearch(arr, 0, y-1, key);

    }
    public static void binarySearch(int arr[], int first, int last, int key){  
        int mid = (first + last)/2;  
        List<Integer> arr1 = new ArrayList<Integer>();
        List<Integer> arr2 = new ArrayList<Integer>();
        while( first <= last ){  
            arr1.add(mid);
            arr2.add(arr[mid]);
            if ( arr[mid] < key ){  
                first = mid + 1;     
            }else if ( arr[mid] == key ){  
                for(int u=0;u<arr1.size();u++){
                    System.out.printf("%d %d\n",arr1.get(u),arr2.get(u));
                }
                break;  
            }else{  
                last = mid - 1;  
            }  
            mid = (first + last)/2;  
            if ( first > last ){  
                for(int u=0;u<arr1.size();u++){
                    System.out.printf("%d %d\n",arr1.get(u),arr2.get(u));
                } 
             }  
        }   
    }  
}




 
