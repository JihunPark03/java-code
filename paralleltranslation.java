import java.util.Scanner;

class paralleltranslation {
     public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int s =sc.nextInt();
        int x =sc.nextInt();
        int y =sc.nextInt();
        char arr[][]=new char[s][s];
        char tarr[][]=new char[s][s];
        for (int i=0;i<s;i++){
            arr[i]=sc.next().toCharArray();
        }
        for(int i=0; i<s; i++){  
            for (int j=0; j<s; j++){
                tarr[i][j]='.';
            }
        }
        if(x >= 0 && y >= 0){
            for(int k = 0; k < s - x; k++){
                for(int p = 0; p < s - y; p++){
                    tarr[p + y][k + x] = arr[p][k];
                }
            }
        }
        else if (x < 0 && y >= 0) {
            for (int k = s - 1; k >= -x; k--) {
                for (int p = 0; p < s - y; p++) {
                    tarr[p + y][k + x] = arr[p][k];
                }
            }
        }
        else if (x >= 0 && y < 0) {
            for (int k = 0; k < s - x; k++) {
                for (int p = s - 1; p >= -y; p--) {
                    tarr[p + y][k + x] = arr[p][k];
                }
            }
        }
        else if ((x < 0 && y < 0)){
            for (int k = s - 1; k >= -x; k--) {
                for (int p = s - 1; p >= -y; p--) {
                    tarr[p + y][k + x] = arr[p][k];
                }
            }
        }
        for(int i=0; i<s; i++){  
            for (int j=0; j<s; j++){
                System.out.print(tarr[i][j]);
            }
            System.out.println();
        }
        sc.close();
    }


}