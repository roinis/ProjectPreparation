import org.junit.Test;

import static org.junit.Assert.*;

public class TewwtEventTest {

    @Test
    public void testToString() {

        TewwtEvent tewwtEvent = new TewwtEvent("wattsup");
        assertEquals(tewwtEvent.toString(),"wattsup");
    }

}