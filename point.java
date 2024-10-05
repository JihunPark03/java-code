import java.util.Scanner;

class point {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int s =sc.nextInt();
        int x =sc.nextInt();
        int y =sc.nextInt();
        char arr[][]=new char[s][s];
        for (int i=0;i<s;i++){
            arr[i]=sc.next().toCharArray();
        }
        arr[y][x]='A';
        System.out.println();
        for(int i=0; i<s; i++){  
            for (int j=0; j<s; j++){
                System.out.print(arr[j][i]);
            }
            System.out.println();
        }
        sc.close();
    }
}