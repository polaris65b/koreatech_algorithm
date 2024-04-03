package week03;

import java.util.Arrays;
import java.util.Scanner;

class Point implements Comparable<Point> {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point p) {
        return this.x - p.x;
    }
}

public class pC {
    static final int MAX = 10000;
    static Point[] points;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            points = new Point[N];

            for (int i = 0; i < N; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                points[i] = new Point(x, y);
            }

            Arrays.sort(points);
            System.out.printf("%.2f\n", closestPair(0, N - 1) );
        }
        scanner.close();
    }

    static double closestPair(int start, int end) {
        if (end - start + 1 <= 3)
            return bruteForce(start, end);

        int mid = (start + end) / 2;
        double distLeft = closestPair(start, mid);
        double distRight = closestPair(mid + 1, end);
        double minDist = Math.min(distLeft, distRight);

        return Math.min(minDist, merge(start, end, mid, minDist));
    }

    static double merge(int start, int end, int mid, double dist) {
        Point[] strip = new Point[end - start + 1];
        int stripIdx = 0;

        for (int i = start; i <= end; i++) {
            if (Math.abs(points[i].x - points[mid].x) < dist) {
                strip[stripIdx] = points[i];
                stripIdx++;
            }
        }

        Arrays.sort(strip, 0, stripIdx, (p1, p2) -> p1.y - p2.y);

        double minDist = dist;
        for (int i = 0; i < stripIdx; i++) {
            for (int j = i + 1; j < stripIdx && (strip[j].y - strip[i].y) < minDist; j++) {
                double d = distance(strip[i], strip[j]);
                if (d < minDist)
                    minDist = d;
            }
        }
        return minDist;
    }

    static double distance(Point p1, Point p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }

    static double bruteForce(int start, int end) {
        double minDist = MAX * 2;
        for (int i = start; i <= end; i++) {
            for (int j = i + 1; j <= end; j++) {
                double d = distance(points[i], points[j]);
                if (d < minDist)
                    minDist = d;
            }
        }
        return minDist;
    }
}