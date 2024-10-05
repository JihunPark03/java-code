import java.util.*;

public class eq2{
    public static final int N = 8;
    static int[][] board = new int[8][8];
    static List<Integer> li = new ArrayList<Integer>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        int count=0;
        while (true) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            count++;
            li.add(w);
            board[h][w]=1;
            if(count==n){
                break;
            }
        }
        put_queen(0);

        for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == 1) {
                        System.out.print("Q");
                    } else {
                        System.out.print(".");
                    }
                }
                System.out.println();
        }
    }
    
    private static boolean put_queen(int col){
        if(col >= N) return true;

        for(int t=0;t<li.size();t++){
            int p=li.get(t);
            if(col==p){
                put_queen(col+1);
            }
        }
        
        for(int i=0; i < N; i++){

            if(check(i, col) == true){
                board[i][col] = 1;

                if(put_queen(col+1) == true){
                    return true;
                }
                
                board[i][col] = 0;
            }
        }
        return false;
    }
    
    private static boolean check(int row, int col){
        int i,j;
        
        for(i = 0; i < col; i++){
            if(board[row][i] == 1){
                return false;
            }
        }

        for(i = row, j = col; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 1){
                return false;
            }
        }
        
        for(i = row, j = col; i < N && j >= 0; i++, j--){
            if(board[i][j] == 1){
                return false;
            }
        }
        return true;
    }
}