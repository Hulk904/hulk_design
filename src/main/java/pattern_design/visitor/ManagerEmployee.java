package pattern_design.visitor;

/**
 * Created by yangyuan on 2018/3/27.
 */
public class ManagerEmployee extends Employee{

    private String performance;

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }
}
