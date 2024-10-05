import java.util.Scanner;
import java.util.*;
    
public class Main {
    public static void main(String[] args) {
        // Prepare for reading data from the standard input
        Scanner sc = new Scanner(System.in);
        List<Integer> li = new ArrayList<Integer>();
        while (true) {
            // Read two words as two integers
            int m = sc.nextInt();
            int f = sc.nextInt();
            int r = sc.nextInt();
            if (m == -1 && f == -1 && r==-1) {
                break;
            }
            li.add(m);
            li.add(f);
            li.add(r);
        }
        for (int k=0;k<li.size();k+=3){
            int twotest=0;
            if(li.get(k)==-1){
                twotest=li.get(k+1);
            }
            else if(li.get(k+1)==-1){
                twotest=li.get(k);
            }
            else if(li.get(k)==-1&&li.get(k+1)==-1){
                twotest=0;
            }
            else{
                twotest=li.get(k)+li.get(k+1);
            }
            if(twotest>=30&&twotest<50&&li.get(k+2)>=50){
                System.out.print("C\n");
            }
            else if(li.get(k)==-1||li.get(k+1)==-1){
                System.out.print("F\n");
            }
            else{
                char grade='A';
                if(twotest>=80){
                    grade='A';
                }
                else if(twotest>=65&&twotest<80){
                    grade='B';
                }
                else if(twotest>=50&&twotest<65){
                    grade='C';
                }
                else if(twotest>=30&&twotest<50){
                    grade='D';
                }
                else if(twotest<30){
                    grade='F';
                }
                System.out.printf("%c\n",grade);
            }
        }
    }

}