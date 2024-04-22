package week01;

import java.util.Scanner;

public class tb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 테스트 케이스의 수
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt(); // 정수의 개수
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) arr[i] = scanner.nextInt(); // 정수 입력
            mergeSort(arr, 0, N - 1); // 합병정렬 실행
            for (int num : arr) System.out.print(num + " "); // 정렬된 배열 출력
            System.out.println();
        }
        scanner.close();
    }
    // 합병정렬
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid); // 왼쪽 부분 배열 정렬
            mergeSort(arr, mid + 1, right); // 오른쪽 부분 배열 정렬
            merge(arr, left, mid, right); // 병합
        }
    }
    // 병합
    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1]; // 임시 배열
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (i = left, k = 0; i <= right; i++, k++) arr[i] = temp[k];
    }
}
