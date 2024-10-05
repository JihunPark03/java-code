import java.util.Scanner;
import java.lang.Math;

public class bis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K =Integer.parseInt(sc.nextLine());
        double lowerLimit = 0;
        double upperLimit = K;
        double diff=Math.abs(lowerLimit-upperLimit);

        while (diff>=Math.pow(10,-6)){
            double center = lowerLimit + (upperLimit - lowerLimit) / 2;
            double candidateK = center * center;
            System.out.printf("%f %f %f %f\n", lowerLimit, center, upperLimit, candidateK);
            if(candidateK<K){
                lowerLimit=center;
            }
            else{
                upperLimit=center;
            }
            diff=Math.abs(lowerLimit-upperLimit);
        }
        
        // Output lowerLimit, center, upperLimit, and candidateK separated by spaces on a single line with System.out.printf().
        // Update lowerLimit or upperLimit with center by comparing candidateK with K. 
    }  
}




 
