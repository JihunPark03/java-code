import java.util.Scanner;

public class bubblesort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y =sc.nextInt();
        int arr[]=new int[y];
        for(int i=0; i<y; i++){  
        arr[i]=sc.nextInt();  
        }  
        int count=0;
        while(true){
            count=1;
            for(int u=0;u<y-1;u++){
                if(arr[u+1]>arr[u]){
                    count++;
                    
                }
            }
            if(count==y){
                break;
            }
            for(int i=0; i < y; i++){  
                int temp = 0; 
                for(int j=1; j < (y-i); j++){  
                    if(arr[j-1] > arr[j]){  
                        temp = arr[j-1];  
                        arr[j-1] = arr[j];  
                        arr[j] = temp;  
                        for(int u=0;u<y;u++){
                            System.out.printf("%d ",arr[u]);
                        }
                        System.out.println();
                    }  
                }  
            }  
            break;      
        }
        sc.close();
    }
}