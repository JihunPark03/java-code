import java.util.Scanner;
import java.lang.Math;

public class ts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A =sc.nextInt();
        int B =sc.nextInt();
        double lowerLimit = 0;
        double upperLimit = Math.pow(10,9);
        double diff=Math.abs(lowerLimit-upperLimit);

        while (diff>=Math.pow(10,-6)){
            double x1 = lowerLimit + (upperLimit - lowerLimit) / 3;
            double x2 = upperLimit - (upperLimit - lowerLimit) / 3;
            double y1 = A * Math.pow(x1,2) + B * x1;
            double y2 = A * Math.pow(x2,2) + B * x2;
            System.out.printf("%f %f %f %f %f %f\n", lowerLimit, x1, x2, upperLimit, y1, y2);
            if(y1<y2){
                lowerLimit=x1;
            }
            else{
                upperLimit=x2;
            }
            diff=Math.abs(lowerLimit-upperLimit);
        }
        
    }  
}




 
