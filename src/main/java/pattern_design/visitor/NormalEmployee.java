package pattern_design.visitor;

/**
 * Created by yangyuan on 2018/3/27.
 */
public class NormalEmployee extends Employee {

    private String job;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
