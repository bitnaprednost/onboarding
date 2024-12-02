package aoc_2023.day6;

import java.util.ArrayList;

public class Race {
    public int calculateWins (String race_data) {
        int winNumber = 1;

        // Split the file content into lines
        String[] lines = race_data.split(System.lineSeparator());

        String[] timeArray = lines[0].split(":")[1].trim().split("\\s+");
        String[] distanceArray = lines[1].split(":")[1].trim().split("\\s+");

        Long[] times = new Long[timeArray.length];
        Long[] distances = new Long[timeArray.length];
        for (int i = 0; i < timeArray.length; i++)
        {
            times[i] = Long.parseLong(timeArray[i]);
            distances[i] = Long.parseLong(distanceArray[i]);
        }

        // Calculate wins for all times
        for (int i = 0; i < times.length; i++)
        {
            int win = (calculatePossibleWins(times[i], distances[i] ));
            winNumber *= win;
        }

        return winNumber;
    }

    public int calculateWins2 (String race_data) {
        int winNumber = 1;

        // Split the file content into lines
        String[] lines = race_data.split(System.lineSeparator());

        String[] timeArray = lines[0].split(":")[1].trim().split("\\s+");
        String[] distanceArray = lines[1].split(":")[1].trim().split("\\s+");

        StringBuilder timeString = new StringBuilder();
        StringBuilder distanceString = new StringBuilder();
        for (int i = 0;  i < timeArray.length; i++)
        {
            timeString.append(timeArray[i]);
            distanceString.append(distanceArray[i]);
        }

        Long time = Long.parseLong(timeString.toString());
        Long distance = Long.parseLong(distanceString.toString());

        // Calculate win number
        winNumber = (calculatePossibleWins(time, distance ));

        return winNumber;
    }

    public int calculatePossibleWins(Long time, Long distance)
    {
        int wins = 0;
        Long starting_speed = 0L;

        for (int i = 0; i <= time; i++)
        {
            // i equals to holding time
            Long speed = starting_speed + i;
            Long t = time - i;

            // Calculate distance
            Long d = speed*t;
            if (d > distance)
            {
                wins++;
            }
        }
        return wins;
    }
}
