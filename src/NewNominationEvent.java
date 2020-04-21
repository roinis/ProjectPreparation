import java.time.LocalDateTime;

public class NewNominationEvent implements Event {
    Team team;
    Member member;
    String nomination;
    LocalDateTime gameDelayedTime;

    public NewNominationEvent(Team team, Member member, String nomination) {
        this.team = team;
        this.member = member;
        this.nomination = nomination;
    }

    @Override
    public String toString() {
        return member.getFull_name()
                +" appointed to new "
                +nomination
                + " of team" + team.getTeamName();
    }

    public Member getMember() {
        return member;
    }
}
