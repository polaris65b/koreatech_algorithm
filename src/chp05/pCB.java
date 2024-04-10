package chp05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

public class pCB {
    static class Section {
        Integer min = null;
        Integer max = null;
        void add(int num) {
            if (min == null || num < min) min = num;
            if (max == null || num > max) max = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            
            if (N == 1) {
                br.readLine();
                bw.write("0\n");
                continue;
            }

            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            String[] numsStr = br.readLine().split(" ");
            int[] nums = new int[N];
            
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
                if (nums[i] < min) min = nums[i];
                if (nums[i] > max) max = nums[i];
            }

            double sectionSize = (double) (max - min) / (N - 1);
            int sectionCount = (int) Math.ceil((max - min) / sectionSize) + 1;
            Section[] sections = new Section[sectionCount];

            for (int i = 0; i < sectionCount; i++)
                sections[i] = new Section();

            for (int num : nums) {
                int index = (int) ((num - min) / sectionSize);
                sections[index].add(num);
            }

            int maxGap = 0, previousMax = sections[0].max;
            
            for (int i = 1; i < sectionCount; i++) {
                if (sections[i].min != null) {
                    maxGap = Math.max(maxGap, sections[i].min - previousMax);
                    previousMax = sections[i].max;
                }
            }
            bw.write(maxGap + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
