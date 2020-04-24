import java.time.LocalDateTime;

public class NewNominationEvent implements Event {
    Team team;
    Member member;
    String nomination;

    public NewNominationEvent(Team team, Member member, String nomination) {
        this.team = team;
        this.member = member;
        this.nomination = nomination;
    }

    @Override
    public String toString() {
        return member.getFull_name()
                +" appointed to the new "
                + nomination
                + " of team " + team.getTeamName();
    }

    public Member getMember() {
        return member;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getNomination() {
        return nomination;
    }

    public void setNomination(String nomination) {
        this.nomination = nomination;
    }

    @Override
    public void addEventToLog() {
        //AlphaSystem.getSystem().getLog().addEvent(this);
    }
}
