package aoc_2024.day5;

import io.ReadFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    public static void main(String[] args) {
        // Specify the file name
        String fileName = "src/main/resources/aoc_2024/day5/Pages.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        PageOrderingRules rules = new PageOrderingRules();
        rules.orderingRules(fileContent);

        // task 1
        PageOrderValidator validator = new PageOrderValidator(rules.getRules(), rules.getPrintPages());
        int result = validator.getValidUpdatesMiddleSum();

        logger.debug("Task 1 result: {}", result);

        // task 2
        OrderUpdate validator2 = new OrderUpdate(rules.getRules(), rules.getPrintPages());
        result = validator2.getValidUpdatesMiddleSum();
        logger.debug("Task 2 result: {}", result);

    }
    static final Logger logger = LoggerFactory.getLogger(Main.class);
}
