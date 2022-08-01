package codewars.at.kyu4.nextbiggerNumberWithSameDigits;

import java.util.ArrayList;
import java.util.List;

public class Kata
{
    public static long nextBiggerNumber(long n)
    {
        if(n <12){
            return -1;
        }
        List<String> permutations = new ArrayList<>();
        permute(permutations,  n+"", 0);
        permutations.remove(0);
        long solution = 0;
        for (String permutation : permutations) {
            long dif = Long.parseLong(permutation) - n;
            if (((solution - n) > dif || solution == 0) && dif > 0){
                solution = Long.parseLong(permutation);
            }
        }

        if(solution - n <= 0){
            return -1;
        }
        return solution;
    }

    private static void permute(List<String> permutations, String currentPermutation, int index)
    {
        int lastIndex = currentPermutation.length()-1;
        if (index == lastIndex)
            permutations.add(currentPermutation);
        else
        {
            for (int i = index; i <= lastIndex; i++)
            {
                currentPermutation = swap(currentPermutation,index,i);
                permute(permutations, currentPermutation, index+1);
                currentPermutation = swap(currentPermutation,index,i);
            }
        }
    }


    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

}