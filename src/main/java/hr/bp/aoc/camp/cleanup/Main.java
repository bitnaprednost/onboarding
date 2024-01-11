package hr.bp.aoc.camp.cleanup;

import hr.bp.aoc.util.Reader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import java.nio.file.Path;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.IntStream;

/**
 * <p>Main class.</p>
 *
 * @author Marko Krišković
 */
public class Main {
	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	private static List<List<List<Integer>>> textToListHell(String input) {
		List<List<List<Integer>>> result = new ArrayList<>();
		String[] split = input.split("\n");

		for (String line : split) {
			int[] numbers = Arrays.stream(
				line.split("[,-]")
			).mapToInt(
				Integer::parseInt
			).toArray();
			List<Integer> temp1 = IntStream.rangeClosed(
				numbers[0], numbers[1]
			).boxed(
			).toList();
			List<Integer> temp2 = IntStream.rangeClosed(
				numbers[2], numbers[3]
			).boxed(
			).toList();
			List<List<Integer>> list = List.of(temp1, temp2);
			result.add(list);
		}

		return result;
	}

	public static <T> Boolean bifunctionBoolean(List<List<T>> array, BiPredicate<List<T>, List<T>> bifunction) {
		Iterator<List<T>> iterator = array.stream().iterator();

		return bifunction.test(iterator.next(), iterator.next());
	}

	private static long getCountIf(List<List<List<Integer>>> lists, BiPredicate<List<Integer>, List<Integer>> biPredicate) {
		return lists.stream(
		).map(
				twoArrays -> bifunctionBoolean(twoArrays, biPredicate)
		).filter(
				pred -> pred
		).count();
	}

	public static void main(String[] args) throws IOException {
		Path path = Path.of("src/main/resources/day4Data.txt");
		String input = Reader.getTextFromFile(path);

		//format: [[[2,3,4],  [6,7,8]], [...], ...]
		List<List<List<Integer>>> lists = textToListHell(input);

		BiPredicate<List<Integer>, List<Integer>> containsEachOther = (first, second) -> first.containsAll(second) || second.containsAll(first);
		BiPredicate<List<Integer>, List<Integer>> matchesOneElement = (first, second) -> first.stream(
		).anyMatch(
			second::contains
		);

		long result1 = getCountIf(lists, containsEachOther);
		logger.info(String.valueOf(result1));

		long result2 = getCountIf(lists, matchesOneElement);
		logger.info(String.valueOf(result2));
	}

}