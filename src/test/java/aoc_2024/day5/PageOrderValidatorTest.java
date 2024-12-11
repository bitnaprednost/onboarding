package aoc_2024.day5;

import io.ReadFile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PageOrderValidatorTest {

    PageOrderingRules rules = new PageOrderingRules();

    @Test
    void getValidUpdatesMiddleSum_example() {

        String input = """
                47|53
                97|13
                97|61
                97|47
                75|29
                61|13
                75|53
                29|13
                97|29
                53|29
                61|53
                97|53
                61|29
                47|13
                75|47
                97|75
                47|61
                75|61
                47|29
                75|13
                53|13
                
                75,47,61,53,29
                97,61,53,29,13
                75,29,13
                75,97,47,61,53
                61,13,29
                97,13,75,29,47
                """;

        rules.orderingRules(input);

        PageOrderValidator validator = new PageOrderValidator(rules.getRules(), rules.getPrintPages());
        assertEquals(143, validator.getValidUpdatesMiddleSum());
    }

    @Test
    void getValidUpdatesMiddleSum_input_puzzle(){

        // Specify the file name
        String fileName = "src/main/resources/aoc_2024/day5/Pages.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        rules.orderingRules(fileContent);

        PageOrderValidator validator = new PageOrderValidator(rules.getRules(), rules.getPrintPages());
        assertEquals(4569, validator.getValidUpdatesMiddleSum());
    }
}