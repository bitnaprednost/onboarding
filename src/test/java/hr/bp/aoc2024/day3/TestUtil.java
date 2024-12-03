package hr.bp.aoc2024.day3;

import java.util.List;

public class TestUtil {

    public static List<String> getExpectedCommandsTestInput() {
        return List.of(
                "mul(2,4)",
                "mul(5,5)",
                "mul(11,8)",
                "mul(8,5)"
        );
    }

    public static String getTestInput() {
        return "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))";
    }
}
