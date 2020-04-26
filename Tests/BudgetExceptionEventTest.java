import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BudgetExceptionEventTest {

    @Test
    public void testToString() {
        /**
         Budget budget = new Budget(new Team("HBS",null,null));
         budget.addDeposit(100.0,"add");
         budget.addDeposit(150.0,"add");
         BudgetExceptionEvent budgetExceptionEvent = new BudgetExceptionEvent(budget.get);
         **/

        TeamOwner teamOwner = new TeamOwner(new Member("","","","check"));
        BudgetExceptionEvent budgetExceptionEvent = new BudgetExceptionEvent(8000,40,new Team("HBS",teamOwner,null));
        String eventString = "The budget of the Team: " + budgetExceptionEvent.getTeam().getTeamName() +" has has been exceeded by " +
                budgetExceptionEvent.getException() + "\n Accepted budget: " +
                budgetExceptionEvent.getBudget() + "\n Current budget: " + (budgetExceptionEvent.getBudget() + budgetExceptionEvent.getException());
        assertEquals(eventString,budgetExceptionEvent.toString());
    }

    @Test
    public void testToString1() {
        TeamOwner teamOwner = new TeamOwner(new Member("","","","check"));
        BudgetExceptionEvent budgetExceptionEvent = new BudgetExceptionEvent(8000,40,new Team("HBS",teamOwner,null));
        String eventString = "The budget of the Team: " + budgetExceptionEvent.getTeam().getTeamName() +" has has been exceeded by " +
                budgetExceptionEvent.getException() + "\n Accepted budget: " +
                budgetExceptionEvent.getBudget() + "\n Current budget: " + (budgetExceptionEvent.getBudget() + budgetExceptionEvent.getException());
        budgetExceptionEvent.setBudget(500);
        assertNotEquals(eventString,budgetExceptionEvent.toString());
    }


    @Test
    public void getBudget() {
        TeamOwner teamOwner = new TeamOwner(new Member("","","","check"));
        BudgetExceptionEvent budgetExceptionEvent = new BudgetExceptionEvent(8000,40,new Team("HBS",teamOwner,null));
        assertEquals(8000,budgetExceptionEvent.getBudget());
    }

    @Test
    public void setBudget() {
        TeamOwner teamOwner = new TeamOwner(new Member("","","","check"));
        BudgetExceptionEvent budgetExceptionEvent = new BudgetExceptionEvent(8000,40,new Team("HBS",teamOwner,null));
        budgetExceptionEvent.setBudget(10);
        assertEquals(10,budgetExceptionEvent.getBudget());
    }

    @Test
    public void getException() {
        TeamOwner teamOwner = new TeamOwner(new Member("","","","check"));
        BudgetExceptionEvent budgetExceptionEvent = new BudgetExceptionEvent(8000,40,new Team("HBS",teamOwner,null));
        assertEquals(40,budgetExceptionEvent.getException());
    }

    @Test
    public void setException() {
        TeamOwner teamOwner = new TeamOwner(new Member("","","","check"));
        BudgetExceptionEvent budgetExceptionEvent = new BudgetExceptionEvent(8000,40,new Team("HBS",teamOwner,null));
        budgetExceptionEvent.setException(20);
        assertEquals(20,budgetExceptionEvent.getException());
    }

    @Test
    public void getTeam() {
        TeamOwner teamOwner = new TeamOwner(new Member("","","","check"));
        Team team = (new Team("HBS",teamOwner,null));
        BudgetExceptionEvent budgetExceptionEvent = new BudgetExceptionEvent(8000,40,team);
        assertEquals(team,budgetExceptionEvent.getTeam());
    }

    @Test
    public void setTeam() {
        TeamOwner teamOwner = new TeamOwner(new Member("","","","check"));
        Team team = (new Team("HBS",teamOwner,null));
        Team team1 = (new Team("HBS1",teamOwner,null));
        BudgetExceptionEvent budgetExceptionEvent = new BudgetExceptionEvent(8000,40,team);
        budgetExceptionEvent.setTeam(team1);
        assertEquals(team1,budgetExceptionEvent.getTeam());
    }
}