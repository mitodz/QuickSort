import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void swap(int a, int b) {
        int buf = a;
        a = b;
        b = buf;
    }

    public static int binarySearchHigh(int[] a, int k) {
        int l = -1; //фиктивная левая граница поиска нужного числа
        int r = a.length; //фиктивная правая граница поиска нужного числа
        while (r > l + 1) {
            int m = l + ((r - l) >> 1); //номер индекса согласно алгоритма "разделяй и властвуй"
            if (a[m] < k) {
                l = m;
            } else {
                r = m;
            }
        }
        return l + 1;
    }

    public static int binarySearchLow(int[] a, int k) {
        int l = -1; //фиктивная левая граница поиска нужного числа
        int r = a.length; //фиктивная правая граница поиска нужного числа
        while (r > l + 1) {
            int m = l + ((r - l) >> 1); //номер индекса согласно алгоритма "разделяй и властвуй"
            if (a[m] <= k) {
                l = m;
            } else {
                r = m;
            }
        }
            return l + 1;
    }

    public int partition(int[] a, int l, int r) {
        Random rnd = new Random();
        int y = rnd.nextInt(r + 1 - l) + l;//случайный разделитель
        swap(a[l], a[y]);
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] < x) {
                j++;
                swap (a[i], a[j]);
            }
            if (a[i] == x) {
                swap (a[i], a[j]);
                j++;
            }
        }
        swap (a[l], a[j]);
        return j;
    }

    public void quickSort(int[] a, int l, int r) {
        //if (l > r) return;
        while (l < r) {
            int m = partition(a, l, r);
            quickSort(a, l, m - 1);
            l = m + 1; //хвостовая рекурсия
            //quickSort(a, m + 1, r);
        }
    }

    public void run() {
        Scanner scanner = new Scanner("5 3\n" +
                "0 5\n" +
                "5 6\n" +
                "3 6\n" +
                "4 5\n" +
                "3 6\n" +
                "1 6 11"); //Ответ 1 3 0
//        Scanner scanner = new Scanner("6 6\n" +
//                "0 3\n" +
//                "1 3\n" +
//                "2 3\n" +
//                "3 4\n" +
//                "3 5\n" +
//                "3 6\n" +
//                "1 2 3 4 5 6"); //Ответ  2 3 6 3 2 1
        int n = scanner.nextInt(); // количество отрезков
        int m = scanner.nextInt(); // количество точек
        int[] a = new int[n]; // массив координат начала отрезков
        int[] b = new int[n]; // массив координат концов отрезков
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
        }
        int[] p = new int[m]; // массив точек
        for (int j = 0; j < m; j++) {
            p[j] = scanner.nextInt();
        }

        quickSort(a, 0, a.length - 1);
        int x = 0;
        quickSort(b, 0, b.length - 1);
        int y = 0;

        for (int i = 0; i < p.length; i++) {
            x = binarySearchLow(a, p[i]);
            y = binarySearchHigh(b, p[i]);
            System.out.print((x - y) + " ");
        }
    }

    public static void main(String[] args) {
        //long startTime = System.currentTimeMillis();
        new Main().run();
        //long finishTime = System.currentTimeMillis();
        //System.out.println(finishTime - startTime + " ms");
    }
}
