import org.junit.Test;

import static org.junit.Assert.*;

public class CoachTest {

    @Test
    public void  tweetsTest(){
        Coach coach=new Coach(null,Coach.Certification.MainCoach);
        coach.addTweet("test");
        assertTrue(coach.getTweets().contains("test"));
        coach.deleteTweet(0);
        assertFalse(coach.getTweets().contains("test"));
    }

    @Test
    public void observerTest(){
        Observer observer=new Observer() {
            @Override
            public void update(Event newEvent) {
                assertTrue(true);
            }
        };
        Coach coach=new Coach(null,Coach.Certification.MainCoach);
        coach.register(observer);
        assertTrue(coach.getObservers().contains(observer));
        coach.notifyObserver(new TewwtEvent("test"));
        coach.unregister(observer);
        assertFalse(coach.getObservers().contains(observer));
    }

    @Test
    public void teamTest(){
        TeamOwner teamOwner=new TeamOwner(null);
        Team team=new Team("hapoel",teamOwner,null);
        Coach coach=new Coach(null,Coach.Certification.MainCoach);
        assertTrue(coach.addToTeam(team,"test"));
        assertEquals("test",coach.getJobInTheTeam());
        assertEquals(team,coach.getTeam());
        assertFalse(coach.addToTeam(team,""));
        assertEquals("test",coach.getJobInTheTeam());
        assertTrue(coach.removeFromTeam());
        assertEquals(null,coach.getTeam());
        assertEquals(null,coach.getJobInTheTeam());
        assertFalse(coach.removeFromTeam());
    }

    @Test
    public void CertificationTest(){
        Coach coach=new Coach(null,Coach.Certification.MainCoach);
        assertEquals(Coach.Certification.MainCoach,coach.getCertification());
    }

}
