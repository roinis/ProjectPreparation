import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EventLog {
    private static EventLog eventLog = null;
    private List<Event> events = null;
    private String saveFilePath = null;

    public static EventLog getEventLog() {
        if(eventLog == null) {
            eventLog = new EventLog();
            eventLog.events = new ArrayList<>();
        }
        return eventLog;
    }

    public void addEvent(Event newEvent){
        events.add(newEvent);
    }

    public void removeEvent(Event removeEvent){
        int eventIndex = events.indexOf(removeEvent);
        events.remove(eventIndex);
    }

    public void saveEventsToDB(){
        BufferedWriter writer = null;
        try
        {
            writer = new BufferedWriter( new FileWriter( saveFilePath));
            for(Event event :events)
                writer.write(event.toString());
        }
        catch ( IOException e)
        {
        }
        finally
        {
            try
            {
                if ( writer != null)
                    writer.close( );
            }
            catch ( IOException e)
            {
            }
        }
    }

}
