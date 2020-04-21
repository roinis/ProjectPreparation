public class Ticket {
    static int ID;
    Member WrittenBy;
    boolean Answered;
    String Complaint;
    String Answer;
    String TicketID;

    public Ticket(Member writtenBy, String complaint){
        Answered = false;
        Complaint = complaint;
        WrittenBy = writtenBy;
        TicketID = Integer.toString(ID);
        ID++;
        AlphaSystem system = AlphaSystem.getSystem();
        system.AddtoDB(10, this);
    }

    public String getTicketID(){
        return TicketID;
    }

    public boolean getIfAnswered(){
        return Answered;
    }

    public void AnswerTicket(String answer){
        Answered = true;
        Answer = answer;
        //WrittenBy.update(); ??
    }

    public String getComplaint(){
       return Complaint;
    }

    public String getAnswer(String answer){
        return Answer;
    }

}
