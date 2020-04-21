import java.time.LocalDateTime;

public class RemoveNominationEvent implements Event {
    Team team;
    Member member;
    String nomination;
    LocalDateTime gameDelayedTime;

    public RemoveNominationEvent(Team team, Member member, String nomination) {
        this.team = team;
        this.member = member;
        this.nomination = nomination;
    }

    @Override
    public String toString() {
            return "The "
                    +nomination
                    +" "
                    + member.getFull_name()
                    + " of team" + team.getTeamName()
                    + "has fired.";
    }

    public Member getMember() {
        return member;
    }
}
