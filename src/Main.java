import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public int partition(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i < r; i++) {
            if (a[i]<=x) {
                j++;
                int buf = a[i];
                a[i] = a[j];
                a[j] = buf;
            }
        }
        int buf = a[j];
        a[j] = a[l];
        a[l] = buf;
        return j;
    }

    public void quickSort (int[] a, int l, int r) {
        if (l > r) return;
        int m = partition(a,l,r);
        quickSort(a,l,m-1);
        quickSort(a,m+1,r);
    }

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
        System.out.println(Arrays.toString(a));
        quickSort(a,1,a.length);
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new Main().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}
