import java.util.Scanner;

public class fastsort1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int I = scanner.nextInt();

        int[] sortedRemainders = fibonacciSort(N, M);

        System.out.println(sortedRemainders[I - 1]);
        scanner.close();
    }

    private static int[] fibonacciSort(int N, int M) {
        int[] fib = new int[N];
        int[] remainders = new int[N];

        fib[0] = 0;
        remainders[0] = 0;

        for (int i = 1; i < N; i++) {
            fib[i] = (i == 1) ? 1 : (fib[i - 1] + fib[i - 2]) % M;
            remainders[i] = fib[i] % M;
        }

        int[] count = new int[M];
        for (int i = 0; i < N; i++) {
            count[remainders[i]]++;
        }

        for (int i = 1; i < M; i++) {
            count[i] += count[i - 1];
        }

        int[] sortedRemainders = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            sortedRemainders[--count[remainders[i]]] = remainders[i];
        }

        return sortedRemainders;
    }
}
