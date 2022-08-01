package codewars.at.kyu5.simplePigLatin;

import codewars.at.kyu5.simplePigLatin.PigLatin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PigLatinTest {
    @Test
    public void FixedTests() {
        assertEquals("igPay atinlay siay oolcay", PigLatin.pigIt("Pig latin is cool"));
        assertEquals("hisTay siay ymay tringsay !", PigLatin.pigIt("This is my string !"));
    }
}