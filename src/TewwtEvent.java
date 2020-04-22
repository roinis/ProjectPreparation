public class TewwtEvent implements Event {
    String tewwt;

    public TewwtEvent(String tewwt) {
        tewwt = tewwt;
    }

    @Override
    public String toString() {
        return tewwt;
    }

    @Override
    public void addEventToLog() {
        //AlphaSystem.getSystem().getLog().addEvent(this);
    }
}
