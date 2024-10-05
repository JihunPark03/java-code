import java.util.Scanner;

public class selectionsort {
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
            for (int i = 0; i < y - 1; i++)  {  
                int index = i;  
                for (int j = i + 1; j < y; j++){  
                    if (arr[j] < arr[index]){  
                        index = j;
                    }  
                }  
                int smallerNumber = arr[index];   
                arr[index] = arr[i];  
                arr[i] = smallerNumber;  
                if (arr[index]!=arr[i]){
                    for(int u=0;u<y;u++){
                        System.out.printf("%d ",arr[u]);
                    }
                    System.out.println();
                }
            } 
            break;      
        }
        sc.close();
    }
}