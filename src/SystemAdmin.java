import java.util.Scanner;

public class SystemAdmin {

    public void CloseTeam(Team TeamToClose){
        TeamToClose.setStatus(Team.Status.close);
    }

    public void RemoveMember(Member member) {
        AlphaSystem system = AlphaSystem.getSystem();
        system.RemoveMember(member);
    }

    public void GetNextTicket(){
        Scanner sc = new Scanner(System.in);
        AlphaSystem system = AlphaSystem.getSystem();
        Ticket TicketToAnswer = system.GetNextUnansweredTicket();
        TicketToAnswer.getComplaint();
        String Answer = sc.next();
        TicketToAnswer.AnswerTicket(Answer);
    }

    public Logger GetLog(){
        AlphaSystem system = AlphaSystem.getSystem();
        return system.getLog();
    }



}
