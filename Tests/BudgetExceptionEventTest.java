import org.junit.Test;

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
        BudgetExceptionEvent budgetExceptionEvent = new BudgetExceptionEvent(8000,40,new Team("HBS",null,null));
        String eventString = "The budget of the Team: " + budgetExceptionEvent.getTeam().getTeamName() +" has has been exceeded by " +
                budgetExceptionEvent.getException() + "\n Accepted budget: " +
                budgetExceptionEvent.getBudget() + "\n Current budget: " + (budgetExceptionEvent.getBudget() + budgetExceptionEvent.getException());
        assertEquals(eventString,budgetExceptionEvent.toString());
    }

    @Test
    public void testToString1() {

        BudgetExceptionEvent budgetExceptionEvent = new BudgetExceptionEvent(8000,40,new Team("HBS",null,null));
        String eventString = "The budget of the Team: " + budgetExceptionEvent.getTeam().getTeamName() +" has has been exceeded by " +
                budgetExceptionEvent.getException() + "\n Accepted budget: " +
                budgetExceptionEvent.getBudget() + "\n Current budget: " + (budgetExceptionEvent.getBudget() + budgetExceptionEvent.getException());
        budgetExceptionEvent.setBudget(500);
        assertNotEquals(eventString,budgetExceptionEvent.toString());
    }


}