package hr.bp.aoc.day2;

import java.util.HashMap;
import java.util.Map;

public class CubeGameParser {
    public ConfigurationOfCubes parse(String game) {
        int gameId = findGameId(game.split(":")[0]);

        Map<String, Integer> cubes = new HashMap<>();
        cubes.put("blue", 0);
        cubes.put("red", 0);
        cubes.put("green", 0);

        String revealedGames = game.split(":")[1];
        for (String revealedGame : revealedGames.split(";")) {
            checkNumCubes(cubes, revealedGame);
        }

        return new ConfigurationOfCubes(cubes.get("blue"), cubes.get("red"), cubes.get("green"), gameId);
    }

    private void checkNumCubes(Map<String, Integer> cubes, String revealedGame) {
        String[] revealdCubes = revealedGame.split(",");

        for (String cube : revealdCubes) {
            String color = cube.strip().split(" ")[1].strip();
            int num = Integer.parseInt(cube.strip().split(" ")[0].strip());

            if (cubes.get(color) < num) {
                cubes.put(color, num);
            }
        }
    }

    private int findGameId(String game) {
        String id = game.split(" ")[1];
        return Integer.parseInt(id);
    }
}
