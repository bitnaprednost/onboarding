package hr.bp.aoc.days.tuningTrouble;

import hr.bp.aoc.days.calorieCounting.DayOne;
import hr.bp.aoc.util.ParserUtil;
import hr.bp.aoc.model.Day;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Luka Ljubić
 */
public class DaySix implements Day {

    public static final Logger logger = LoggerFactory.getLogger(DaySix.class);

    String getBufferDataPath = "src/main/resources/bufferData.txt";
    String bufferData = ParserUtil.parseFromPath(getBufferDataPath);

    @Override
    public void executePartOne() {
        Optional<Integer> positionInString = processBufferData(bufferData, 4);

        if (positionInString.isPresent()){
            logger.info("tuningTrouble PART 1: {}",positionInString );
        }
        else {
            logger.error("Integer je Optional.empty");
        }
    }

    @Override
    public void executePartTwo() {
        Optional<Integer> positionInString = processBufferData(bufferData, 14);

        if (positionInString.isPresent()){
            logger.info("tuningTrouble PART 2: {}",positionInString );
        }
        else {
            logger.error("Integer je Optional.empty");
        }
    }

    @Override
    public String getDayOrderNumber() {
        return "Day Six";
    }

    private Optional<Integer> processBufferData(String bufferData, int numberOfCharactersInASequence) {
        int tempPosition = 0;

        List<Character> sequence = new ArrayList<>();

        for (int i = 0; i<bufferData.length(); i++){
            if (i == bufferData.length()-numberOfCharactersInASequence){
                break;
            }
            addToSequence(sequence, i, numberOfCharactersInASequence);

            if(hasNoDuplicates(sequence)){
                tempPosition = i+numberOfCharactersInASequence;
                return Optional.of(tempPosition);
            }
            else{
                sequence.clear();
            }

        }

        return Optional.empty();
    }

    private void addToSequence(List<Character> sequence, int index, int numberOfsequenceCharacters) {
        for(int i = 0; i<numberOfsequenceCharacters; i++){
            sequence.add(bufferData.charAt(index +i));
        }
    }

    private boolean hasNoDuplicates(List<Character> sequence) {
        List<Character> uniqueList = sequence.stream()
                .distinct()
                .collect(Collectors.toList());

        return uniqueList.size() == sequence.size();
    }
}
