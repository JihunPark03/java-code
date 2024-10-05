import java.util.Scanner;
import java.io.*;

public class combsort {
    int getNextGap(int gap){
		gap = (gap*10)/13;
		if (gap < 1)
			return 1;
		return gap;
	}
	void sort(int arr[]){
        int p=arr.length;
		int gap = p;
		boolean swapped = true;
		while (gap != 1 || swapped == true){
			gap = getNextGap(gap);
			swapped = false;
			for (int i=0; i<p-gap; i++){
				if (arr[i] > arr[i+gap]){
					int temp = arr[i];
					arr[i] = arr[i+gap];
					arr[i+gap] = temp;
					swapped = true;
                    for(int u=0;u<p;u++){
                        System.out.printf("%d ",arr[u]);
                    }
                    System.out.println();
				}
			}
		}
	}
    public static void main(String[] args) {
        combsort ob = new combsort();
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


