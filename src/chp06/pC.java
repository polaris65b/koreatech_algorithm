package chp06;

import java.util.Random;
import java.util.Scanner;

public class pC {
    private static Random rand = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = scanner.nextInt();
            }
            wiggleSort(nums);
            System.out.println(N);
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void wiggleSort(int[] nums) {
        int n = nums.length;
        quickSelect(nums, 0, n - 1, n / 2);
        int median = nums[n / 2];

        int left = 0, mid = 0, right = n - 1;
        while (mid <= right) {
            if (nums[mid] < median) {
                swap(nums, left++, mid++);
            } else if (nums[mid] > median) {
                swap(nums, mid, right--);
            } else {
                mid++;
            }
        }

        int[] temp = new int[n];
        int small = left - 1;
        int large = n - 1;
        for (int i = 0; i < n; i += 2) {
            temp[i] = nums[small--];
        }
        for (int i = 1; i < n; i += 2) {
            temp[i] = nums[large--];
        }

        System.arraycopy(temp, 0, nums, 0, n);
    }

    private static void quickSelect(int[] arr, int left, int right, int index) {
        if (left >= right) return;

        int pivotIndex = partition(arr, left, right);
        if (pivotIndex == index) {
            return;
        } else if (pivotIndex > index) {
            quickSelect(arr, left, pivotIndex - 1, index);
        } else {
            quickSelect(arr, pivotIndex + 1, right, index);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivotIndex = left + rand.nextInt(right - left + 1);
        int pivotValue = arr[pivotIndex];
        swap(arr, pivotIndex, right);
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, i, storeIndex++);
            }
        }
        swap(arr, storeIndex, right);
        return storeIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
