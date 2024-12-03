package hr.bp.aoc2024.day1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    public long getSimilarityScore() {
        Map<Long, Long> frequencyLeftInRight = getFrequencyLeftInRight();

        long similarityScore = 0;

        for (long numLeft : left) {
            similarityScore += numLeft * frequencyLeftInRight.get(numLeft);
        }

        return similarityScore;
    }

    private Map<Long, Long> getFrequencyLeftInRight() {
        Map<Long, Long> frequencyMap = new HashMap<>();

        for (Long numLeft : left) {
            long frequency = right.stream().filter(numRight -> Objects.equals(numLeft, numRight)).count();
            frequencyMap.putIfAbsent(numLeft, frequency);
        }
        return frequencyMap;
    }
}
