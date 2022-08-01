package codewars.at.kyu4.squareIntoSquares;

//codewars challenge link:
//https://www.codewars.com/kata/5263c6999e0f40dee200059d

//solution to slow but overall working

import java.util.LinkedList;
import java.util.List;

public class Decompose {

    public String decompose(long n) {
        long searched = (long) Math.pow(n, 2);
        List<List<Long>> possibilities = new LinkedList<>();

        long limit = n * 0.5 > n - 10 ? (long) (n * 0.5) : n - 10;
        for (long i = n - 1; i > limit; i--) {
            findSolution(possibilities, new LinkedList<>(), 0, searched, i);
        }

        if (possibilities.size() == 0) {
            return null;
        }

        final StringBuilder solution = new StringBuilder();
        possibilities.get(0).stream().sorted().forEach(aLong -> solution.append(aLong).append(" "));
        return solution.substring(0, solution.length() - 1);
    }

    public void findSolution(List<List<Long>> possibilities, List<Long> currentNumbers, long currentSum, long numberSearched, long currentNumber) {
        if (possibilities.size() > 0) {
            return;
        }

        currentSum += Math.pow(currentNumber, 2);
        currentNumbers.add(currentNumber);
        if (currentSum == numberSearched) {
            possibilities.add(currentNumbers);
            return;
        }
        if (currentSum < numberSearched) {
            long nextNumber = Math.round(Math.sqrt(numberSearched - currentSum));
            if (nextNumber >= currentNumber) {
                return;
            }
            for (long i = nextNumber; i > 0; i--) {
                findSolution(possibilities, new LinkedList<>(currentNumbers), currentSum, numberSearched, i);
            }
        }
        return;
    }
}
