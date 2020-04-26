import org.junit.Test;

import static org.junit.Assert.*;

public class TewwtEventTest {

    @Test
    public void testToString() {

        TewwtEvent tewwtEvent = new TewwtEvent("wattsup");
        assertEquals(tewwtEvent.toString(),"wattsup");
    }

    @Test
    public void getTewwt() {
        TewwtEvent tewwtEvent = new TewwtEvent("wattsup");
        assertEquals(tewwtEvent.getTewwt(),"wattsup");
    }

    @Test
    public void setTewwt() {
        TewwtEvent tewwtEvent = new TewwtEvent("wattsup");
        tewwtEvent.setTewwt("check");
        assertEquals(tewwtEvent.getTewwt(),"check");
    }
}