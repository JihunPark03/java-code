import java.util.Scanner;

public class dict {
    public static void main(String[] args) {
        
        
    }
    public static int linearSearch(int[] arr, int key){    
        for(int i=0;i<arr.length;i++){    
            if(arr[i] == key){    
                return i;    
            }    
        }    
        return -1;    
    }   
}




 
