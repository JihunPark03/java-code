import java.util.Scanner;

class fill {
     public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int s =sc.nextInt();
        int x =sc.nextInt();
        int y =sc.nextInt();
        char arr[][]=new char[s][s];
        for (int i=0;i<s;i++){
            arr[i]=sc.next().toCharArray();
        }
        fillArea (arr, y, x);
        for(int i=0; i<s; i++){  
            for (int j=0; j<s; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        sc.close();
    }

    private static void fillArea(char[][] array, int startX, int startY) {
        if (startX < 0 || startX >= array.length || startY < 0 || startY >= array[0].length || array[startX][startY] != '.')
            return;

        array[startX][startY] = '#';
        fillArea(array, startX - 1, startY);
        fillArea(array, startX + 1, startY);
        fillArea(array, startX, startY - 1);
        fillArea(array, startX, startY + 1);
    }
}