package codewars.at.theOvservedPIN;

import java.util.*;

//codewars puzzle link:
//https://www.codewars.com/kata/5263c6999e0f40dee200059d
public class ObservedPin {
    //used to find the adjacent numbers from the observed number
    public static final Map<String, List<String>> ADJACENT_NUMBERS = Map.of(
            "1", Arrays.asList("1", "2", "4"),
            "2", Arrays.asList("2", "1", "3", "5"),
            "3", Arrays.asList("3", "2", "6"),
            "4", Arrays.asList("4", "1", "5", "7"),
            "5", Arrays.asList("5", "2", "4", "6", "8"),
            "6", Arrays.asList("6", "3", "5", "9"),
            "7", Arrays.asList("7", "4", "8"),
            "8", Arrays.asList("8", "5", "7", "9", "0"),
            "9", Arrays.asList("9", "6", "8"),
            "0", Arrays.asList("0", "8")
    );


    public static List<String> getPINs(String observed) {
        List<List<String>> observedVariations = new LinkedList<>();
        List<String> possibilities = new LinkedList<>();
        for (String number : observed.split("")) {
            observedVariations.add(ADJACENT_NUMBERS.get(number));
        }
        variation(possibilities, observed.length(), observedVariations, "");
        return possibilities;
    }


    /**
     * @param possibilities contains all the possible variation found
     * @param length        is the length of the pin
     * @param variations    contains all possible numbers at each position
     * @param current       is the current pin
     */
    public static void variation(List<String> possibilities, int length, List<List<String>> variations, String current) {
        if (current.length() == length) {
            possibilities.add(current);
            return;
        }

        for (String number : variations.get(current.length())) {
            variation(possibilities, length, variations, current + number);
        }
    }

} // ObservedPin
