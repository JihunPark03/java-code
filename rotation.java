import java.util.Scanner;

class rotation {
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
        for(int k = 0; k < s ; k++){
            for(int p = 0; p < s; p++){
                tarr[k][s-p-1] = arr[p][k];
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