import java.util.Scanner;
import java.lang.Math;

public class shellsort {

    int value(int arr[]){
        int n = arr.length; 
        int number=0;
        for (int i=1;i<=5;i++){
            if(Math.pow(3, i)<=(n/3+ (n % 3 > 0 ? 1 : 0))*2+1){
                number++;
            }
        }
        return number;
    }

	int sort(int arr[]) { 
		int n = arr.length; 
        int number=value(arr);
		for (int interval=(int)((Math.pow(3, number) - 1)/2); interval > 0; interval /= 3) { 
			for (int i = interval; i < n; i ++) { 
				int temp = arr[i]; 
				int j; 
				for (j = i; j >= interval && arr[j - interval] > temp; j -= interval){
                    arr[j] = arr[j - interval]; 
                }
				arr[j] = temp;  
                if(arr[i]!=arr[j]){
                    for(int u=0;u<n;u++){
                        System.out.printf("%d ",arr[u]);
                    }
                    System.out.println();
                }
			} 
		} 
		return 0; 
	} 
    public static void main(String[] args) {
        shellsort ob = new shellsort();
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
            ob.sort(arr);
        }
        sc.close();
    }
}


