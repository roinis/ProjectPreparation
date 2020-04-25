import org.junit.Test;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;
public class MemberTest {


    @Test
    public void editPersonalInformationTest1(){

        String input = "1\n"+"tamir";
        try{
            Member m = new Member("roei","1234","12345","roei cohen");
            InputStream inputStream1 = new ByteArrayInputStream(input.getBytes("UTF8"));
            System.setIn(inputStream1);
            m.editPersonalInformation();
            assertEquals("tamir",m.getUser_name());
        }catch (UnsupportedEncodingException e){
            e.fillInStackTrace();
        }
    }

    @Test
    public void editPersonalInformationTest2(){

        String input = "2\n"+"050244";
        try{
            Member m = new Member("tamir","1234","12345","roei cohen");
            InputStream inputStream1 = new ByteArrayInputStream(input.getBytes("UTF8"));
            System.setIn(inputStream1);
            m.editPersonalInformation();
            assertEquals("050244",m.getUser_password());
        }catch (UnsupportedEncodingException e){
            e.fillInStackTrace();
        }
    }

    @Test
    public void editPersonalInformationTest3(){

        String input = "3\n"+"204702";
        try{
            Member m = new Member("tamir","050244","12345","roei cohen");
            InputStream inputStream1 = new ByteArrayInputStream(input.getBytes("UTF8"));
            System.setIn(inputStream1);
            m.editPersonalInformation();
            assertEquals("204702",m.getUser_id());
        }catch (UnsupportedEncodingException e){
            e.fillInStackTrace();
        }
    }

    @Test
    public void editPersonalInformationTest4(){

        String input = "4\n"+"tamir levi";
        try{
            Member m = new Member("tamir","050244","204702","roei cohen");
            InputStream inputStream1 = new ByteArrayInputStream(input.getBytes("UTF8"));
            System.setIn(inputStream1);
            m.editPersonalInformation();
            assertEquals("tamir levi",m.getFull_name());
        }catch (UnsupportedEncodingException e){
            e.fillInStackTrace();
        }
    }


    @Test
    public void addJobTest1(){

        Member m = new Member("roei","1234","12345","roei cohen");
        Player p = new Player(m, Player.Position.CF,LocalDate.of(1992,7,23));
        m.addJob(p);
        assertTrue(m.getJobsList().size()==1);
        assertTrue(m.getJobsList().containsKey("player"));
    }

    @Test
    public void addRefereeTest1(){

        Member m = new Member("roei","1234","12345","roei cohen");
        Referee r = new Referee(m);
        assertTrue(m.addReferee(r));
    }

    @Test
    public void addRefereeTest2(){

        Member m = new Member("roei","1234","12345","roei cohen");
        Referee r = new Referee(m);
        assertTrue(m.addReferee(r));
        Player p = new Player(m, Player.Position.CF,LocalDate.of(1992,7,23));
        assertFalse(m.addJob(p));
    }

    @Test
    public void newComplaintTest1(){
        Member m = new Member("roei","1234","12345","roei cohen");
        String new_complaint = "something is not working";
        try {
            InputStream inputStream1 = new ByteArrayInputStream(new_complaint.getBytes("UTF8"));
            System.setIn(inputStream1);
            m.newComplaint();
            assertEquals(new_complaint,m.getTicketList().get(0).Complaint);
        }
        catch (UnsupportedEncodingException e){
            e.fillInStackTrace();
        }
    }

    @Test
    public void getUserNameTest(){
        Member m = new Member("roei","1234","12345","roei cohen");
        assertEquals("roei",m.getUser_name());
    }

    @Test
    public void getUserPasswordTest(){
        Member m = new Member("roei","1234","12345","roei cohen");
        assertEquals("1234",m.getUser_password());
    }

    @Test
    public void getUserIDTest(){
        Member m = new Member("roei","1234","12345","roei cohen");
        assertEquals("12345",m.getUser_id());
    }

    @Test
    public void getUserFullNameTest(){
        Member m = new Member("roei","1234","12345","roei cohen");
        assertEquals("roei cohen",m.getFull_name());
    }

    @Test
    public void followFootballGameTest(){
        String input = "t1\n"+ "hapoel\n"+"maccabi";
        Member m = new Member("roei","1234","12345","roei cohen");
        TeamOwner teamOwner1 = new TeamOwner(null);
        TeamOwner teamOwner2 = new TeamOwner(null);
        Team team1 = new Team("hapoel", teamOwner1, null);
        Team team2 = new Team("maccabi", teamOwner2, null);
        League l=new League("t1",null,null);
        l.addSeason(1990,null,null);
        l.getCurrentSeason().addTeamToSeason(team1);
        l.getCurrentSeason().addTeamToSeason(team2);
        l.getCurrentSeason().scheduleGames();
        AlphaSystem.getSystem().AddtoDB(1,l);
        try{
            InputStream inputStream1 = new ByteArrayInputStream(input.getBytes("UTF8"));
            System.setIn(inputStream1);
            m.followFootballGame();
            List<FootballGame> games = l.getCurrentSeason().getGames();
            FootballGame footballGameObserved= null;
            for(FootballGame footballGame:games){
                if(footballGame.getHomeTeamName().equals("hapoel")&& footballGame.getAwayTeamName().equals("maccabi")){
                    assertTrue(footballGame.getFanObservers().contains(m));
                    footballGameObserved = footballGame;
                }
            }
            footballGameObserved.unregister(m);
            assertFalse(footballGameObserved.getFanObservers().contains(m));
        }catch (UnsupportedEncodingException e){
            e.fillInStackTrace();
        }
    }

    @Test
    public void followPersonalPageTest1(){
        String input = "1\n"+"1";
        TeamOwner teamOwner1 = new TeamOwner(null);
        Team team1 = new Team("hapoel", teamOwner1, null);
        Member m = new Member("roei","1234","12345","roei cohen");
        try{
            InputStream inputStream1 = new ByteArrayInputStream(input.getBytes("UTF8"));
            System.setIn(inputStream1);
            m.followPersonalPage();
            assertTrue(team1.getFanObservers().contains(m));
            team1.unregister(m);
            assertFalse(team1.getFanObservers().contains(m));
        }catch (UnsupportedEncodingException e){
            e.fillInStackTrace();
        }
    }

    @Test
    public void followPersonalPageTest2(){
        String input = "2\n"+"1";
        Member m = new Member("roei","1234","12345","roei cohen");
        Player p = new Player(m, Player.Position.CF,LocalDate.of(1992,7,23));
        try{
            InputStream inputStream1 = new ByteArrayInputStream(input.getBytes("UTF8"));
            System.setIn(inputStream1);
            m.followPersonalPage();
            assertTrue(p.getObservers().contains(m));
            p.unregister(m);
            assertFalse(p.getObservers().contains(m));
        }catch (UnsupportedEncodingException e){
            e.fillInStackTrace();
        }
    }

    @Test
    public void followPersonalPageTest3(){
        String input = "3\n"+"1";
        Member m = new Member("roei","1234","12345","roei cohen");
        Coach c = new Coach(m,Coach.Certification.MainCoach);
        try{
            InputStream inputStream1 = new ByteArrayInputStream(input.getBytes("UTF8"));
            System.setIn(inputStream1);
            m.followPersonalPage();
            assertTrue(c.getObservers().contains(m));
            c.unregister(m);
            assertFalse(c.getObservers().contains(m));
        }catch (UnsupportedEncodingException e){
            e.fillInStackTrace();
        }
    }




















    
}
