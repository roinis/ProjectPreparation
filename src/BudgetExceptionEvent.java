public class BudgetExceptionEvent implements Event {
    int budget;
    int exception;
    Team team;
    public BudgetExceptionEvent(int budget, int exception,Team team) {
        this.budget = budget;
        this.exception = exception;
        this.team = team;
    }

    @Override
    public String toString() {
        return "The budget of the Team: " + team.getTeamName() +" has has been exceeded by " +
                exception + "\n Accepted budget: " +
                budget + "\n Current budget: " + (exception + budget);
    }

    @Override
    public void addEventToLog() {
            //AlphaSystem.getSystem().getLog().addEvent(this);
    }
}
