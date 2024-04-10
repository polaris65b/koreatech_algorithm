package chp05;

import java.util.Random;
import java.util.Scanner;

public class pA {
    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(arr, start, end);
            quickSort(arr, start, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivotIndex = new Random().nextInt(end - start + 1) + start;
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, end);
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, end);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int[] arr = new int[N];

            for (int i = 0; i < N; i++)
                arr[i] = scanner.nextInt();

            quickSort(arr, 0, N - 1);


            for (int i = 0; i < N; i++)
                System.out.print(arr[i] + " ");
            
            System.out.println();
        }
        scanner.close();
    }
}