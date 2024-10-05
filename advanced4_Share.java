import java.util.Scanner;
import java.util.Arrays;

public class advanced4_Share{
    public static final int MAXSIZE = 8;
    public static int[][] BOARD = new int[MAXSIZE][MAXSIZE];
    public static int[] QUEENPOS = new int[MAXSIZE];
    public static int CNT = 0;
        
    public static void main(String[] args){
        for(int i=0; i<MAXSIZE; i++){
            Arrays.fill(BOARD[i], 0);
        } 

        Scanner sc = new Scanner(System.in);

        int inputNum = sc.nextInt();

        for(int i=0; i<inputNum; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            BOARD[x][y] = 2;
        }
        nQueen(0, 0);
        showBoard();

        sc.close();
    }

    public static void showBoard(){
        for(int i=0; i<MAXSIZE; i++){
            for(int j=0; j<MAXSIZE; j++){
                if(BOARD[i][j]==0){
                    System.out.print(".");
                }else{
                    System.out.print("Q");
                }
            }
            System.out.println("");
        }
    }

    public static boolean check(int x, int y){
        //Up
        for(int i=0; i<y; i++){
            if(BOARD[x][i]!=0) return false;
        }
        //Dn
        for(int i=y+1; i<MAXSIZE; i++){
            if(BOARD[x][i]!=0) return false;
        }
        //L
        for(int i=0; i<x; i++){
            if(BOARD[i][y]!=0) return false;
        }
        //R
        for(int i=x+1; i<MAXSIZE; i++){
            if(BOARD[i][y]!=0) return false;
        }

        
        //LU
        int i=x-1;
        int j=y-1;
        while(i>=0 && j>=0){
            if(BOARD[i][j]!=0) return false;
            i--;
            j--;
        }
        //RD
        i = x+1;
        j = y+1;
        while(i<MAXSIZE && j<MAXSIZE){
            if(BOARD[i][j]!=0) return false;
            i++;
            j++;
        }
        //LD
        i = x-1;
        j = y+1;
        while(i>=0 && j<MAXSIZE){
            if(BOARD[i][j]!=0) return false;
            i--;
            j++;
        }
        //RU
        i = x+1;
        j = y-1;
        while(i<MAXSIZE && j>=0){
            if(BOARD[i][j]!=0) return false;
            i++;
            j--;
        }
        return true;
    }

    public static boolean nQueen(int y, int newX){
        if(CNT==MAXSIZE) return true;

        boolean isQueenExist, isRecFinish=false;
        for(int j=y; j<MAXSIZE; j++){
            isQueenExist = false;

            for(int i=newX; i<MAXSIZE; i++){
                if(check(i, j)){
                    if(BOARD[i][j] != 2){
                        BOARD[i][j] = 1;
                    }
                    QUEENPOS[j] = i;
                    isQueenExist = true;
                    CNT++;
                    isRecFinish = nQueen(y+1, 0);
                    if(isRecFinish) return true;
                    break;
                }
            }

            if(isQueenExist!=true){
                if(BOARD[QUEENPOS[j-1]][j-1] != 2){
                    BOARD[QUEENPOS[j-1]][j-1] = 0;
                }
                CNT--;
                isRecFinish = nQueen(j-1, QUEENPOS[j-1]+1);
                if(isRecFinish) return true;
            }
            if(isQueenExist) break;
        }
        return false;
    }
}