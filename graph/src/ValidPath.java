import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class ValidPath {
    /*
    There is a rectangle with left bottom as  (0, 0) and right up as (x, y). There are N circles such that their centers are inside the rectangle.
    Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without touching any circle.

    Note : We can move from any cell to any of its 8 adjecent neighbours and we cannot move outside the boundary of the rectangle at any point of time.


    Input Format

    1st argument given is an Integer x.
    2nd argument given is an Integer y.
    3rd argument given is an Integer N, number of circles.
    4th argument given is an Integer R, radius of each circle.
    5th argument given is an Array A of size N, where A[i] = x cordinate of ith circle
    6th argument given is an Array B of size N, where B[i] = y cordinate of ith circle
    Output Format

    Return YES or NO depending on weather it is possible to reach cell (x,y) or not starting from (0,0).
    Constraints

    0 <= x, y, R <= 100
    1 <= N <= 1000
    Center of each circle would lie within the grid
    For Example

    Input:
        x = 2
        y = 3
        N = 1
        R = 1
        A = [2]
        B = [3]
    Output:
        NO

    Explanation:
        There is NO valid path in this case
     */
    public static void main(String[] args) {
        ValidPath solution = new ValidPath();

        String answer1 = solution.solve(2, 3, 1, 1, new ArrayList<>(List.of(2)), new ArrayList<>(List.of(3)));
        System.out.println(answer1);

        String answer2 = solution.solve(41, 67, 5, 0,
                new ArrayList<>(List.of(5, 17, 16, 12, 0, 40)),
                new ArrayList<>(List.of(5, 52, 61, 61, 25, 31)));
        System.out.println(answer2);
    }


    public String solve(int x, int y, int circlesNumber, int radius, ArrayList<Integer> centerX, ArrayList<Integer> centerY) {
        Point finishPoint = new Point(x, y);

        Set<Point> visitedNodes = new HashSet<>();
        Queue<Point> queue = new LinkedList<>();
        Point startPoint = new Point(0, 0);
        queue.add(startPoint);
        visitedNodes.add(startPoint);

        while (!queue.isEmpty()) {
            int levelCount = queue.size();

            for (int i = 0; i < levelCount; i++) {
                Point node = queue.poll();

                Set<Point> nextFreePoints = node.allNeighbours().stream()
                        .filter(point -> point.isBelongsToRectangle(x, y))
                        .filter(point -> !visitedNodes.contains(point))
                        .filter(point -> !point.isBelongsToCircles(radius, centerX, centerY))
                        .collect(Collectors.toSet());

                visitedNodes.addAll(nextFreePoints);

                if (nextFreePoints.contains(finishPoint)) {
                    return "YES";
                }

                queue.addAll(nextFreePoints);
            }
        }

        return "NO";
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private List<Point> allNeighbours() {
            ArrayList<Point> neighbours = new ArrayList<>();

            neighbours.add(new Point(x, y + 1));
            neighbours.add(new Point(x + 1, y + 1));
            neighbours.add(new Point(x + 1, y));
            neighbours.add(new Point(x + 1, y - 1));
            neighbours.add(new Point(x, y - 1));
            neighbours.add(new Point(x - 1, y - 1));
            neighbours.add(new Point(x - 1, y));
            neighbours.add(new Point(x - 1, y + 1));

            return neighbours;
        }

        private boolean isBelongsToCircles(int radius, ArrayList<Integer> centerX, ArrayList<Integer> centerY) {
            boolean belong = false;
            for (int i = 0; i < centerX.size() && !belong; i++) {
                belong = isBelongsToCircle(radius, centerX.get(i), centerY.get(i));
            }
            return belong;
        }

        private boolean isBelongsToCircle(int radius, int centerX, int centerY) {
            double distance = sqrt(pow(x - centerX, 2) + pow(y - centerY, 2));

            return distance <= radius;
        }

        private boolean isBelongsToRectangle(int recX, int recY) {
            return 0 <= x && x <= recX && 0 <= y && y <= recY;
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