import java.util.Scanner;

public class fg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        String x;
        String end = "END_OF_TEXT";
        int count=0;
        while (true) {
            x = sc.nextLine();
            String[] splitted = x.split(" ");
            for (int i=0; i<splitted.length;i++) {
                if(splitted[i].equals(n)){
                    count++;
                }
            }
            if (x.equals(end)) {
                break;
            }
        }
        System.out.printf("%d",count);
        sc.close();
    }
    
}
