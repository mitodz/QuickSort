import java.util.Scanner;

public class Main {


    public void run() {
        Scanner scanner = new Scanner("2 3\n" +
                "0 5\n" +
                "7 10\n" +
                "1 6 11");
        int n = scanner.nextInt(); // количество отрезков
        int m = scanner.nextInt(); // количество точек
        int[] a = new int[n]; // массив координат отрезков
        for (int i = 0; i < n * 2; i++) {
            a[i] = scanner.nextInt();
        }
        int[] p = new int[m]; // массив точек
        for (int j = 0; j < m; j++) {
            p[j] = scanner.nextInt();
        }

    }

    public static void main(String[] args) {
        // write your code here
    }
}
