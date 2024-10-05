import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class shuffle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> li = new ArrayList<String>();
        String x = sc.nextLine();
        int y = sc.nextInt();
        int count=0;
        String strNew=x;
        while (true){
            int z = sc.nextInt();
            String p="";
            for(int i=0;i<z;i++){
                p+=strNew.charAt(i); 
            }
            strNew = strNew.replaceFirst(p,"");
            strNew+=p;
            count++;
            if(count==y){
                break;
            }
        }
        li.add(strNew);
        System.out.println(li);

        sc.close();
    }
}
           
           
           


