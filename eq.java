import java.util.Scanner;
import java.util.Arrays;

public class eq{
    public static final int max = 8;
    public static int[][] board = new int[max][max];
    public static int[] position = new int[max];
    public static int COL = 0;
        
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=0; i<max; i++){
            Arrays.fill(board[i], 0);
        } 
        int count=0;
        while (true) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            count++;
            board[x][y] = 2;
            if(count==N){
                break;
            }
        }
        nQueen(0, 0);
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                if (board[i][j] == 1) {
                    System.out.print("Q");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
    }
        sc.close();
    }

    public static boolean check(int row, int col){
        for(int i=0; i<col; i++){
            if(board[row][i]!=0) 
            return false;
        }
        for(int i=col+1; i<max; i++){
            if(board[row][i]!=0) 
            return false;
        }
        for(int i=0; i<row; i++){
            if(board[i][col]!=0) 
            return false;
        }
        for(int i=row+1; i<max; i++){
            if(board[i][col]!=0) 
            return false;
        }

        int i=row-1;
        int j=col-1;
        while(i>=0 && j>=0){
            if(board[i][j]!=0) 
            return false;
            i--;
            j--;
        }
        i = row+1;
        j = col+1;
        while(i<max && j<max){
            if(board[i][j]!=0) 
            return false;
            i++;
            j++;
        }
        i = row-1;
        j = col+1;
        while(i>=0 && j<max){
            if(board[i][j]!=0) 
            return false;
            i--;
            j++;
        }
        i = row+1;
        j = col-1;
        while(i<max && j>=0){
            if(board[i][j]!=0) 
            return false;
            i++;
            j--;
        }
        return true;
    }

    public static boolean nQueen(int y, int newX){
        if(COL>=max) return true;

        boolean isQueenExist, isRecFinish=false;
        for(int j=y; j<max; j++){
            isQueenExist = false;

            for(int i=newX; i<max; i++){
                if(check(i, j)){
                    if(board[i][j] != 2){
                        board[i][j] = 1;
                    }
                    position[j] = i;
                    isQueenExist = true;
                    COL++;
                    isRecFinish = nQueen(y+1, 0);
                    if(isRecFinish) return true;
                    break;
                }
            }

            if(isQueenExist!=true){
                if(board[position[j-1]][j-1] != 2){
                    board[position[j-1]][j-1] = 0;
                }
                COL--;
                isRecFinish = nQueen(j-1, position[j-1]+1);
                if(isRecFinish) return true;
            }
            if(isQueenExist) break;
        }
        return false;
    }
}