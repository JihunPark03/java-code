import java.util.Scanner;

public class ls {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y =sc.nextInt();
        int arr []=new int[y];
        for(int i=0; i<y; i++){  
        arr[i]=sc.nextInt();  
        }  
        int key =sc.nextInt();
        int k=0;
        for(int j=0; j<y;j++){
            if(arr[j]>=key){
                k=j;
                break;
            }
        }
        for(int u=0;u<=k;u++){
            System.out.printf("%d %d\n",u,arr[u]);
        }
        sc.close();
    }
}




 
