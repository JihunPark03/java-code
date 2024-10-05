import java.util.Scanner;
import java.util.*;

public class connect4test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char arr[][]={{' ', ' ',' ',' ',' ',' ',' '},{' ', ' ',' ',' ',' ',' ',' '},{' ', ' ',' ',' ',' ',' ',' '},{' ', ' ',' ',' ',' ',' ',' '},
        {' ', ' ',' ',' ',' ',' ',' '},{' ', ' ',' ',' ',' ',' ',' '}};
        int count1=0;
        System.out.print("X:");
        int x = sc.nextInt();
        System.out.print("Y:");
        int y = sc.nextInt();
        System.out.printf("Placed the piece at (%d,%d)!",x,y);
        if(count1%2==0){
            arr[x][y]='O';
        }
        else{
            arr[x][y]='X';
        }  
        System.out.println();
        for (int n = 0 ; n < arr.length ; n++)
        {
            System.out.println(Arrays.toString(arr[n])); 
        } 
        sc.close();
    }
}