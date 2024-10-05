import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class shuffle_final {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> li = new ArrayList<String>();
        int count2=0;
        while (true){
            String x = sc.nextLine();
            if(x.equals("-")){
                break;
            }
            int y = Integer.parseInt(sc.nextLine());// int y =sc.nextInt() 
            int count=0;
            String strNew=x;
            while (true){
                int z = Integer.parseInt(sc.nextLine());
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
            count2++;
        }
        for(int i=0; i<count2;i++){
            System.out.println(li.get(i));
        }
        sc.close();
    }
}
           
           
           


