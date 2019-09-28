import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class PointsOnTheStraightLine {
    /*
    Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
     */

    public static void main(String[] args) {
        PointsOnTheStraightLine solution = new PointsOnTheStraightLine();

        List<Integer> x = List.of(1, 1, 1);
        List<Integer> y = List.of(4, -1, 0);
        System.out.println(solution.maxPoints(new ArrayList<>(x), new ArrayList<>(y)));

        x = List.of(1, 1, 1);
        y = List.of(1, 1, 1);
        System.out.println(solution.maxPoints(new ArrayList<>(x), new ArrayList<>(y)));

        x = List.of(0, 1, -1);
        y = List.of(0, 1, -1);
        System.out.println(solution.maxPoints(new ArrayList<>(x), new ArrayList<>(y)));

        x = List.of(4, 8, -4);
        y = List.of(-4, -4, -4);
        System.out.println(solution.maxPoints(new ArrayList<>(x), new ArrayList<>(y)));
    }

    public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
        int n = a.size();
        if (n < 3) {
            return n;
        }

        HashMap<Point, Integer> hashMap = new HashMap<>();

        int result = 1;

        for (int i = 0; i < n - 1; i++) {
            hashMap.clear();

            int maxValue = 0;
            int overlap = 0;
            for (int j = i + 1; j < n; j++) {
                if (i != j) {

                    Integer slopeX = a.get(j) - a.get(i);
                    Integer slopeY = b.get(j) - b.get(i);

                    if (slopeX == 0 && slopeY == 0) {
                        overlap++;
                        continue;
                    }

                    int gcd = generateGCD(slopeX, slopeY);

                    if (gcd != 0) {
                        slopeX /= gcd;
                        slopeY /= gcd;
                    }

                    Point slope = new Point(slopeX, slopeY);

                    int count = hashMap.getOrDefault(slope, 0) + 1;

                    hashMap.put(slope, count);

                    maxValue = Math.max(maxValue, count);
                }
            }
            int initPointItself = 1;
            result = Math.max(result, maxValue + overlap + initPointItself);
        }

        return result;
    }

    private int generateGCD(int a, int b) {
        if (b == 0) return a;

        return generateGCD(b, a % b);
    }

    static private class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
