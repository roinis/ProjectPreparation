public class BudgetExceptionEvent implements Event {
    private int budget;
    private int exception;
    private Team team;
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

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getException() {
        return exception;
    }

    public void setException(int exception) {
        this.exception = exception;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
