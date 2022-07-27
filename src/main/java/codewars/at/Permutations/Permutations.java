package codewars.at.Permutations;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


//Link to codewars problem:
//https://www.codewars.com/kata/5254ca2719453dcc0b00027d/
public class Permutations {
    public static List<String> singlePermutations(String s) {
        List<String> possibilities = new ArrayList<>();
        permutationRecursion(possibilities, s, "");
        possibilities = possibilities.stream().distinct().collect(Collectors.toList());
        return possibilities;
    }

    public static void permutationRecursion(List<String> possibilities, String lettersLeft, String current){
        if(lettersLeft.length() == 0){
            possibilities.add(current);
            return;
        }
        for (String letter : lettersLeft.split("")) {
            permutationRecursion(possibilities, lettersLeft.replaceFirst(letter, ""), current + letter);
        }
    }

}
