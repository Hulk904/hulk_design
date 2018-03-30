package pattern_design.visitor;

/**
 * Created by yangyuan on 2018/3/27.
 */
public interface Visitor {
    void visit(NormalEmployee normalEmployee);
    void visit(ManagerEmployee managerEmployee);

}
