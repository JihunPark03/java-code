import java.util.Scanner;
import java.io.*;

public class shellsort2 {
    public static void shellSort(int arr[]) {
        int n = arr.length; // n-ソート
        int tmp; // 配列交換で一時的に保存する領域
        while (n > 0) {
            for (int i = 0; i < numbers.length; i++) {
                int j = i;
                tmp = numbers[i]; // 入れ替え元の配列の中身の保存
                // n-ソートを行う為にindex番号を進める また n個前の配列と比較して交換の必要があったら交換する．
                while ((j >= n) && (numbers[j-n] > tmp)) {
                    numbers[j] = numbers[j - n];
                    j = j - n; // n個 ずつ確認をするための処理
                }
                numbers[j] = tmp; // 最後に更新された配列の中身に，入れ替え元を入れる．
                for(int u=0;u<n;u++){
                        System.out.printf("%d ",arr[u]);
                    }
                System.out.println();
            }
            n -= 1; // n の更新
         }
    }
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
            sort(arr);

        }
        sc.close();
    }
}


