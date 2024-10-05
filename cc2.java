import java.util.Scanner;

public class cc2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // array: single variable for each position/ much faster than list
        int [] arr= new int[26];
        while (sc.hasNextLine()) {// for checking the next line
            String x = sc.nextLine();//nextLine input the value until enter input/ next: until the enter and space
            x=x.toLowerCase();
            if(x.length()==0){
                break;
            }
            char k;
            for(int i=0;i<x.length();i++){
                char u=(char)x.charAt(i);
                for(int j=0;j<26;j++){
                    k=(char)(j+97);
                    if(u==k){    
                        arr[j]++;
                    }
                }
                
            } 
        }
        for (int k=0;k<26;k++){
            System.out.printf("%c : %d\n",(char)(k+97), arr[k]);
        }
        sc.close();
    }
}
