import java.util.Scanner; 
import java.util.*;
    
public class rn {
    public static void main(String[] args) {
        // Prepare for reading data from the standard input
        Scanner sc = new Scanner(System.in);
        List<Integer> li = new ArrayList<Integer>();
        int n = sc.nextInt();
        while (true) {
            int h = sc.nextInt();
            li.add(h);
            if(li.size()==n){
                break;
            }
        }
        for (int i=n-1;i>=0;i--){
            if(i!=0){
                System.out.printf("%d ",li.get(i));
            }
            else{
                System.out.printf("%d",li.get(0));
            }
            
            
        }
        sc.close();
    }

}