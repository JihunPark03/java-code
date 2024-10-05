import java.util.Scanner;

public class is {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y =sc.nextInt();
        int arr[]=new int[y];
        for(int i=0; i<y; i++){  
        arr[i]=sc.nextInt();  
        }  
        int count=0;
        System.out.println();
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
            for (int j = 1; j < y; j++) {  
                int key = arr[j];  
                int i = j-1;  
                while ( (i > -1) && ( arr[i] > key ) ) {  
                    arr[i+1] = arr[i];  
                    i--;  
                }  
                arr[i+1] = key;  
                if(arr[j]!=arr[i+1]){
                    for(int u=0;u<y;u++){
                            System.out.printf("%d ",arr[u]);
                    }
                    System.out.println();
                }

            }        
        }
        sc.close();
    }
}