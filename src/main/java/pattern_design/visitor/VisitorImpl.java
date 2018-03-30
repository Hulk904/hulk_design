package pattern_design.visitor;

/**
 * Created by yangyuan on 2018/3/27.
 */
public class VisitorImpl implements Visitor {



    public void visit(NormalEmployee normalEmployee) {
        System.out.println( getNormalEmployeeInfo(normalEmployee));
    }

    private String getNormalEmployeeInfo(NormalEmployee normalEmployee){
        return getBaseInfo(normalEmployee)  + "工作:" + normalEmployee.getJob();
    }

    private String getBaseInfo (Employee employee){
        return "姓名："  + employee.getName()
               + "薪水：" + employee.getSalary()
               + "性别：" + (employee.getSex() ==1 ?"男":"女");
    }

    public void visit(ManagerEmployee managerEmployee) {
        System.out.println(getBaseInfo(managerEmployee) + "成绩：" + managerEmployee.getPerformance());
    }


}
