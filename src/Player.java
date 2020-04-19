import java.util.Date;

public class Player extends Job{
    private Team team;
    enum Position{ST,CF,CAM,LM,CM,RM,CDM,RW,LW,RB,LB,CB,GK}
    private Position position;
    private Date dateOfBirth;

    public Player(Member member,Team team, Position position, Date dateOfBirth) {
        super(member);
        this.team = team;
        this.position = position;
        this.dateOfBirth = dateOfBirth;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}
