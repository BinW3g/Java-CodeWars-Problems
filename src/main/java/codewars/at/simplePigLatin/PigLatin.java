package codewars.at.simplePigLatin;

import java.util.Arrays;
import java.util.List;


//Link to codewars challenge :
//https://www.codewars.com/kata/520b9d2ad5c005041100000f
public class PigLatin {
    public static String pigIt(String str) {
        String[] tokens = str.split(" ");
        String out = "";
        List punctuations = Arrays.asList("!",".","?");
        for (String token : tokens){
            if(punctuations.contains(token)){
                out += token + " ";
            }else{
                out += token.substring(1) + token.charAt(0) + "ay ";
            }
        }
        System.out.printf(out);
        return out.substring(0, out.length()-1);
    }
}