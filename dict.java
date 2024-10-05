import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class dict {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = Integer.parseInt(sc.nextLine());
        List<String> li = new ArrayList<String>();
        String arr2d [][]=new String[y][2];
        int b=0;
        while (b<y) {
            String k=sc.nextLine();
            String[] splitted = k.split(" ");
            for(int j=0;j<2;j++){
                arr2d[b][j]=splitted[j];
            }
            b++;
        }
        for(int j=0;j<y;j++){
            if(arr2d[j][0].equals("insert")){
                li.add(arr2d[j][1]);
            }
            else{
                int count=0;
                String u=arr2d[j][1];
                for(int l=0;l<li.size();l++){
                    if(li.get(l).equals(u)){
                        System.out.println("yes");
                        count=1;
                        break;
                    }
                } 
                if(count!=1){
                    System.out.println("no");
                }
                
            }
        }
        sc.close();
    }
}
