package codewars.at.kyu8.doIGetABonus;

//Link to codwars challenge
//https://www.codewars.com/kata/56f6ad906b88de513f000d96

public class Kata {
    public static String bonusTime(final int salary, final boolean bonus) {
        return bonus ? "£" + salary * 10 : "£" + salary;
    }
}
