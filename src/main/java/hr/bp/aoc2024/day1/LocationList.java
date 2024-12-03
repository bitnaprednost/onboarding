package hr.bp.aoc2024.day1;

import java.util.List;

public class LocationList {
    private List<Long> left;
    private List<Long> right;

    public LocationList(List<List<Long>> lists) {
        this.right = lists.get(0);
        this.left = lists.get(1);
    }

    public long getTotalDistance() {
        List<Long> sortedLeft = List.copyOf(left).stream().sorted().toList();
        List<Long> sortedRight = List.copyOf(right).stream().sorted().toList();

        long totalDistance = 0;

        for (int index = 0; index < sortedLeft.size(); index++) {
            totalDistance += Math.abs(sortedLeft.get(index) - sortedRight.get(index));
        }

        return totalDistance;
    }
}
