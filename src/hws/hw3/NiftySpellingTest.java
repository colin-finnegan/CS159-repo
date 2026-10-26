package hws.hw3;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NiftySpellingTest {

    @Test
    public void testAbecedarian() {
        assertTrue(NiftySpelling.abecedarian("biopsy"));
        assertFalse(NiftySpelling.abecedarian("nifty"));
        assertFalse(NiftySpelling.abecedarian("piano"));
        assertFalse(NiftySpelling.abecedarian("monkey"));
        assertTrue(NiftySpelling.abecedarian("most"));
        assertTrue(NiftySpelling.abecedarian("demo"));
    }
}
