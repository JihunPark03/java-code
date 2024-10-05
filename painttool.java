import java.util.Scanner;
class paralleltranslation {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int s =sc.nextInt();
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
        while (true){
            String str=sc.next();
            if (str.equals("shift")){
                int x =sc.nextInt();
                int y =sc.nextInt();
                shifting(s, x, y, tarr, arr);
                copy(s,tarr,arr);
            }
            else if (str.equals("dot")){
                int t =sc.nextInt();
                int z =sc.nextInt();
                tarr[z][t]='#';
                arr[z][t]=tarr[z][t];
            }
            else if(str.equals("rotate")){
                rotate(s, tarr, arr); 
                copy(s,tarr,arr);
            }
            else if(str.equals("end")){
                break;
            }
        }
        for(int i=0; i<s; i++){  
            for (int j=0; j<s; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        sc.close();
    }
    private static void copy(int s, char tarr[][], char arr[][]) {
        for (int k = 0; k < s; k++) {
            for (int p = 0; p < s; p++) {
                arr[p][k] = tarr[p][k];
            }
        }
    }
    private static void rotate(int s, char tarr[][], char arr[][]) {
        for (int k = 0; k < s; k++) {
            for (int p = 0; p < s; p++) {
                tarr[k][s - p - 1] = arr[p][k];
            }
        }
    }
    private static void shifting(int s, int x, int y, char tarr[][], char arr[][]){
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
        else if (x < 0 && y < 0) {
            for (int k = s - 1; k >= -x; k--) {
                for (int p = s - 1; p >= -y; p--) {
                    tarr[p + y][k + x] = arr[p][k];
                }
            }
        }
    }
}