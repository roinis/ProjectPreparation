import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Player extends Job{
    private Team team;
    enum Position{ST,CF,CAM,LM,CM,RM,CDM,RW,LW,RB,LB,CB,GK}
    private Position position;
    private Date dateOfBirth;
    private List<String> tweets;


    public Player(Member member, Team team, Position position, Date dateOfBirth) {
        super(member);
        this.team = team;
        this.position = position;
        this.dateOfBirth = dateOfBirth;
        this.jobName="player";
        tweets=new ArrayList<>();
        AlphaSystem alphaSystem=AlphaSystem.getSystem();
        alphaSystem.AddtoDB(7,this);
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

    public void addTweet(String tweet){
        tweets.add(tweet);
    }

    public void deleteTweet(int index){
        tweets.remove(index);
    }

}
