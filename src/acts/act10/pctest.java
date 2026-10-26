package acts.act10;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


public class pctest {

    @Test
    public void testConstructor() {
        Child kid = new Child();
        Parent adult = new Parent();
        kid.display();
        adult.display();
        assertEquals("-7 ", kid.display());
        assertEquals("24 ", adult.display());

    }

}
