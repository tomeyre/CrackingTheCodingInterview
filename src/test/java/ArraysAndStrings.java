import org.junit.jupiter.api.Test;

import static org.example.Strings.checkUniqueUsingBooleanArray;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArraysAndStrings {

    private String strUnique = "abcdefghijklmnopqrstuvwxyz";
    private String strNotUnique = "abcdefghijklmnopabcderfghijklmnop";

    @Test
    public void isUniqueAnswer1(){
        assertTrue(checkUniqueUsingBooleanArray(strUnique));
        assertFalse(checkUniqueUsingBooleanArray(strNotUnique));
    }

    @Test
    public void isUniqueAnswer2(){
        assertTrue(checkUniqueUsingBooleanArray(strUnique));
        assertFalse(checkUniqueUsingBooleanArray(strNotUnique));
    }
}
