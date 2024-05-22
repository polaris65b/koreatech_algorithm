package chp08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Job implements Comparable<Job> {
    int id, deadline, profit;

    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    // 이득이 높은 순으로 정렬
    public int compareTo(Job other) {
        return other.profit - this.profit;
    }
}

public class pA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- > 0) {
            int N = scanner.nextInt();
            Job[] jobs = new Job[N];

            for (int i = 0; i < N; i++) {
                int deadline = scanner.nextInt();
                int profit = scanner.nextInt();
                jobs[i] = new Job(i + 1, deadline, profit);
            }

            Arrays.sort(jobs);

            boolean[] slot = new boolean[N];
            ArrayList<Job> scheduledJobs = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                for (int j = Math.min(N, jobs[i].deadline) - 1; j >= 0; j--) {
                    if (!slot[j]) {
                        slot[j] = true;
                        scheduledJobs.add(jobs[i]);
                        break;
                    }
                }
            }

            // 스케줄된 작업을 작업 ID 순으로 정렬
            Collections.sort(scheduledJobs, new Comparator<Job>() {
                public int compare(Job job1, Job job2) {
                    return job1.id - job2.id;
                }
            });

            // 스케줄된 작업의 ID를 출력
            for (Job job : scheduledJobs) {
                System.out.print(job.id + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
