import javafx.util.Pair;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Budget {
    private double budget;
    private List<Pair<LocalDateTime,Pair<Double,String>>> reports;
    private Team team;

    public Budget(Team team) {
        this.team = team;
        reports=new ArrayList<>();
        budget=0;
    }

    public void addWithdraw(Double sum,String description){
        budget-=sum;
        Pair<Double,String> record=new Pair(sum,description);
        Pair<LocalDateTime,Pair<Double,String>> report=new Pair<>(LocalDateTime.now(),record);
        reports.add(report);
        checkBudgetException();
    }

    public void addDeposit(Double sum,String description){
        budget+=sum;
        Pair<Double,String> record=new Pair(sum,description);
        Pair<LocalDateTime,Pair<Double,String>> report=new Pair<>(LocalDateTime.now(),record);
        reports.add(report);
        checkBudgetException();
    }

    private void checkBudgetException() {
        /*if(false)
            team.notifyObserver(new BudgetExceptionEvent(budget,excp,team));*/
    }

    public List<Pair<LocalDateTime, Pair<Double, String>>> getReports() {
        return reports;
    }

    public double getBudget() {
        return budget;
    }
}
