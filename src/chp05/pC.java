package chp05;

import java.util.Scanner;

public class pC {
    static class Bucket {
        Integer min = null;
        Integer max = null;
        void add(int num) {
            if (min == null || num < min) min = num;
            if (max == null || num > max) max = num;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            if (N == 1) {
                scanner.nextInt();
                System.out.println(0);
                continue;
            }

            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = scanner.nextInt();
                if (nums[i] < min) min = nums[i];
                if (nums[i] > max) max = nums[i];
            }

            double bucketSize = (double) (max - min) / (N - 1);
            int bucketCount = (int) Math.ceil((max - min) / bucketSize) + 1;
            Bucket[] buckets = new Bucket[bucketCount];
            
            for (int i = 0; i < bucketCount; i++)
                buckets[i] = new Bucket();


            for (int num : nums) {
                int index = (int) ((num - min) / bucketSize);
                buckets[index].add(num);
            }


            int maxGap = 0, previousMax = buckets[0].max;
            for (int i = 1; i < bucketCount; i++) {
                if (buckets[i].min != null) {
                    maxGap = Math.max(maxGap, buckets[i].min - previousMax);
                    previousMax = buckets[i].max;
                }
            }

            System.out.println(maxGap);
        }
        scanner.close();
    }
}
