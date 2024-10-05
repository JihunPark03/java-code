import java.util.Scanner;
import java.util.*;
    
public class pc {
    public static void main(String[] args) {
        // Prepare for reading data from the standard input
        Scanner sc = new Scanner(System.in);
        List<Integer> li = new ArrayList<Integer>();
        while (true) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            if (h == 0 && w == 0) {
                break;
            }
            li.add(h);
            li.add(w);
        }
        for (int p=0;p<li.size();p+=2){
            for(int i=0;i<li.get(p);i++){
                for(int j=0;j<li.get(p+1);j++){ 
                    if (i%2==0&&j%2==0||j%2!=0&&i%2!=0){
                        System.out.printf("#");
                    }
                    else {
                        System.out.printf(".");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    }

}