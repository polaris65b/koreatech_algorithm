package week03;

import java.util.Scanner;

public class pA {
    private static long mergeAndCount(int[] arr, int[] temp, int left, int right) {
        if (left >= right) return 0;

        int mid = (left + right) / 2;
        long invCount = 0;
        invCount += mergeAndCount(arr, temp, left, mid);
        invCount += mergeAndCount(arr, temp, mid + 1, right);
        invCount += merge(arr, temp, left, mid, right);
        return invCount;
    }

    private static long merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;
        long invCount = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j])
            	temp[k++] = arr[i++];
            else {
                temp[k++] = arr[j++];
                invCount += (mid + 1 - i);
            }
        }

        while (i <= mid)
            temp[k++] = arr[i++];

        while (j <= right)
            temp[k++] = arr[j++];

        for (i = left; i <= right; i++)
            arr[i] = temp[i];

        return invCount;
    }

    public static long countInversions(int[] arr) {
        int[] temp = new int[arr.length];
        return mergeAndCount(arr, temp, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- > 0) {
            int n = scanner.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = scanner.nextInt();

            System.out.println(countInversions(arr));
        }

        scanner.close();
    }
}