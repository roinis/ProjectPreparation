import java.util.ArrayList;
import java.util.List;

public class Coach extends Job {
    private Team team;
    private List<String> tweets;


    public Coach(Member member, Team team) {
        super(member);
        this.team = team;
        this.jobName="coach";
        tweets=new ArrayList<>();
        AlphaSystem alphaSystem=AlphaSystem.getSystem();
        alphaSystem.AddtoDB(3,this);
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void addTweet(String tweet){
        tweets.add(tweet);
    }

    public void deleteTweet(int index){
        tweets.remove(index);
    }
}
