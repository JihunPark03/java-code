import java.util.*;

public class connect4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char arr[][]={{' ', ' ',' ',' ',' ',' ',' '},{' ', ' ',' ',' ',' ',' ',' '},{' ', ' ',' ',' ',' ',' ',' '},{' ', ' ',' ',' ',' ',' ',' '},
        {' ', ' ',' ',' ',' ',' ',' '},{' ', ' ',' ',' ',' ',' ',' '}};
        int count1=0;
        while (true){
            if(count1%2==0){
                System.out.println("Player A's turn");
            }
            else{
                System.out.println("Player B's turn");
            }  
            if (count1!=0){
                System.out.println("Place your piece on position indicated by *");
            }
            System.out.print("X-cooridinate:");
            int x = sc.nextInt();
            placing(arr,x,count1);
            available_space(arr);
            System.out.println();
            for (int n = 0 ; n < arr.length ; n++){
                System.out.println(Arrays.toString(arr[n])); 
            } 
            char order;
            if(count1%2==0){
                order='O';
            }
            else{
                order='X';
            }  
            if( h_check(arr,order)== true || v_check(arr,order)== true || d_check(arr,order)== true){
                if(count1%2==0){
                    System.out.println("Winner is A");
                    break;
                }
                else{
                    System.out.println("Winner is B");
                    break;
                }  
            }
            count1 ++;
        }
        sc.close();
    }
    private static void placing(char arr[][],int x,int count1){
        int y=0;
        for (int i=0;i<=5;i++){
            if(arr[i][x]=='O'||arr[i][x]=='X'){
                y++;
            }
        }
        if(count1%2==0){
            arr[5-y][x]='O';
        }
        else{
            arr[5-y][x]='X';
        }  
    }
    private static void available_space(char arr[][]){
        for(int i=0; i<6; i++){
            for(int j=0; j<7; j++){
                if (arr[i][j]=='X'||arr[i][j]=='O'){
                    if(i-1>=0&&arr[i-1][j]==' '){
                        arr[i-1][j]='*';
                    }
                }
                if(arr[5][j]==' '){
                    arr[5][j]='*';
                }
            }
        }
    }
    private static boolean h_check(char arr[][],char order){
        int count2=0;
        for(int i=0; i<6; i++){
            for(int j=0; j<7; j++){
                if (arr[i][j]==order){
                    count2++;
                    if(count2==4){
                        return true;
                    }
                }
                else{
                    count2=0;
                }
            }
        }
        return false;
    }
    private static boolean v_check(char arr[][],char order){
        int count2=0;
        for(int i=0; i<7; i++){
            for(int j=0; j<6; j++){
                if (arr[j][i]==order){
                    count2++;
                    if(count2==4){
                        return true;
                    }
                }
                else{
                    count2=0;
                }
            }
        }
        return false;
    }
    private static boolean d_check(char arr[][],char order){
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 4; col++) {
                if (arr[row][col] != ' ' &&
                    arr[row][col] == arr[row + 1][col + 1] &&
                    arr[row][col] == arr[row + 2][col + 2] &&
                    arr[row][col] == arr[row + 3][col + 3] &&
                    arr[row][col] != '*') {
                    return true;
                }
            }
        }
        for (int row = 0; row < 3; row++) {
            for (int col = 3; col < 7; col++) {
                if (arr[row][col] != ' ' &&
                    arr[row][col] == arr[row + 1][col - 1] &&
                    arr[row][col] == arr[row + 2][col - 2] &&
                    arr[row][col] == arr[row + 3][col - 3] &&
                    arr[row][col] != '*') {
                    return true;
                }
            }
        }
        return false;
        }  
    }