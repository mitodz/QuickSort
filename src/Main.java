import java.util.Scanner;

public class Main {

    public static void swap(int[] arr, int a, int b) {
        int buf = arr[a];
        arr[a] = arr[b];
        arr[b] = buf;
    }

    public static int binarySearchHigh(int[] a, int k) {
        int l = -1; //фиктивная левая граница поиска нужного числа
        int r = a.length; //фиктивная правая граница поиска нужного числа
        while (r > l + 1) {
            int m = l + ((r - l) >> 1); //номер индекса согласно алгоритма "разделяй и властвуй"
            if (a[m] >= k) {
                r = m;
            } else {
                l = m;
            }
        }
        return r;
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


    public static void quickSort(int[] a, int b, int e) {
        int l = b, r = e;
        int piv = a[(l + r) / 2]; // Опорным элементом для примера возьмём средний
        while (l <= r) {
            while (a[l] < piv)
                l++;
            while (a[r] > piv)
                r--;
            if (l <= r)
                swap(a, l++, r--);
        }
        if (b < r)
            quickSort(a, b, r);
        if (e > l)
            quickSort(a, l, e);
    }


    public void run() {
        Scanner scanner = new Scanner(System.in);
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
