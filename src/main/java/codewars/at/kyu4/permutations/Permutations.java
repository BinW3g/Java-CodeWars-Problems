package codewars.at.kyu4.permutations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


//Link to codewars challenge:
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


    //better solution bc no junk gets produced
    //https://www.baeldung.com/java-array-permutations
    /* Permutation function @param str
       string to calculate permutation
       for @param l starting index
       @param r end index */
    private void permute(String str,
                         int l, int r)
    {
        if (l == r)
            System.out.println(str);
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }

    /* Swap Characters at position
       @param a string value @param
       i position 1 @param j position 2
       @return swapped string */
    public String swap(String a,
                       int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

}
