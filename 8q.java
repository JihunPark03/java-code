import java.util.Scanner;

public class 8q {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.next();
        List<Integer> li = new ArrayList<Integer>();
        while (li.size()=2*n) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            li.add(h);
            li.add(w);
        }
        int[][] arr = new int[7][7];
        for (int i=0;i<2*n;i+=2){
            for (int j=0;j<8;j++){
                arr[li.get(i)][j]=1;
                arr[li.get(i+1)][j]=1;
                arr[li.get(i)+i][li.get(i+1)-i]=1;
                arr[li.get(i)-i][li.get(i+1)-i]=1;
            }
        }
        for(int k=0; k<8;i++){
            for(int m=0;,m<8;m++){
                System.out.println(arr[k][m]);
            }
        }
        
        sc.close();
    }
    
}
