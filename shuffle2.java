import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class shuffle2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> li = new ArrayList<String>();
        String x = sc.nextLine();
        int y = sc.nextInt();
        String p="";
        String strNew=x;
        for(int i=0;i<y;i++){
            p+=strNew.charAt(i); 
        }
        strNew = strNew.replaceFirst(p,"");
        strNew+=p;
        li.add(strNew);
        System.out.println(li);
        sc.close();
    }
}
