package hr.bp.aoc2024.day5;

import java.util.*;

public class PageParser {
    private int PAGE = 1;
    private int PAGE_RULE = 0;

    private List<String> input;

    public PageParser(String input) {
        this(List.of(input.split("\\n")));
    }

    public PageParser(List<String> input) {
        this.input = input;
    }

    public List<ArrayList<Integer>> getProducingOrder() {
        List<ArrayList<Integer>> producingOrder = new ArrayList<>();

        Iterator<String> iterator = input.iterator();
        goToProducingOrder(iterator);

        while (iterator.hasNext()) {
            producingOrder.add(new ArrayList<>(Arrays.stream(iterator.next().strip().split(",")).map(Integer::parseInt).toList()));
        }
        return producingOrder;
    }

    private void goToProducingOrder(Iterator<String> iterator) {
        String current = iterator.next();
        while (iterator.hasNext() && current.contains("|")) {
            current = iterator.next();
        }
    }

    public HashMap<Integer, List<Integer>> getOrderingRules() {
        HashMap<Integer, List<Integer>> orderingRules = new HashMap<>();

        Iterator<String> iterator = input.iterator();
        String rule = iterator.next();

        while (iterator.hasNext() && rule.contains("|")) {
            int page = getPageFromRule(rule, PAGE);
            int pageRule = getPageFromRule(rule, PAGE_RULE);

            orderingRules.putIfAbsent(page, new ArrayList<>());
            orderingRules.get(page).add(pageRule);

            rule = iterator.next();
        }

        return orderingRules;
    }

    private int getPageFromRule(String rule, int pageType) {
        return Integer.parseInt(rule.split("\\|")[pageType].strip());
    }

}
