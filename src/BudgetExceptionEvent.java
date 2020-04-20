public class BudgetExceptionEvent implements event{
    int budget;
    int exception;

    public BudgetExceptionEvent(int budget, int exception) {
        this.budget = budget;
        this.exception = exception;
    }

    @Override
    public String toString() {
        return "The budget has has been exceeded by " +
                exception + "\n Accepted budget: " +
                budget + "\n Current budget: " + (exception + budget);
    }
}
