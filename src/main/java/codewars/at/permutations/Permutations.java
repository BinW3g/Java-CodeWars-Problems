package codewars.at.permutations;

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

//        printAllRecursive(s.length(), s.split(""));
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


    //better solution bc no junk gets produced
    public static <T> void printAllRecursive(int n, T[] elements) {
        if(n == 1) {
            printArray(elements);
        } else {
            for(int i = 0; i < n-1; i++) {
                printAllRecursive(n - 1, elements);
                if(n % 2 == 0) {
                    swap(elements, i, n-1);
                } else {
                    swap(elements, 0, n-1);
                }
            }
            printAllRecursive(n - 1, elements);
        }
    }
    private static <T> void swap(T[] input, int a, int b) {
        T tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    private static <T> void printArray(T[] input) {
        System.out.print('\n');
        for(int i = 0; i < input.length; i++) {
            System.out.print(input[i]);
        }
    }

}
