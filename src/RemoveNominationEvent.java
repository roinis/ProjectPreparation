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
            return member.getFull_name() + " from team " + team.getTeamName()
                    +" has fired from " + nomination
                    + " position.";
    }

    public Member getMember() {
        return member;
    }

    @Override
    public void addEventToLog() {
        //AlphaSystem.getSystem().getLog().addEvent(this);
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

    public LocalDateTime getGameDelayedTime() {
        return gameDelayedTime;
    }

    public void setGameDelayedTime(LocalDateTime gameDelayedTime) {
        this.gameDelayedTime = gameDelayedTime;
    }
}
