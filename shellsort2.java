import java.util.Scanner;
import java.lang.Math;

public class shellsort {

    public static void main(String[] args) {
        shellsort ob = new shellsort();
        Scanner sc = new Scanner(System.in);
        int y =sc.nextInt();
        int arr[]=new int[y];
        for(int i=0; i<y; i++){  
            arr[i]=sc.nextInt();  
        }  
        int n = arr.length; 
        int number=0;
        for (int i=1;i<=5;i++){
            if(Math.pow(3, i)<=(n/3+ (n % 3 > 0 ? 1 : 0))*2+1){
                number++;
            }
        }
        System.out.printf("%d\n",n);
        System.out.printf("%d\n",(n/3+ (n % 3 > 0 ? 1 : 0)));
        System.out.printf("%d\n",number);
        sc.close();
    }
}

