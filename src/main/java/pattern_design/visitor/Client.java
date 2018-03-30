package pattern_design.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2018/3/27.
 * 访问者visitorImpl依赖的具体实现破坏了依赖倒置原则
 * 和迭代器不同的是访问者遍历的是不同的对象，迭代器是同类的对象。
 */
public class Client {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<Employee>();
        NormalEmployee zan = new NormalEmployee();
        zan.setJob("java");
        zan.setName("张三");
        zan.setSalary(1000);
        zan.setSex(1);
        list.add(zan);
        NormalEmployee li = new NormalEmployee();
        li.setJob("页面设计");
        li.setName("李斯");
        li.setSalary(3000);
        li.setSex(2);
        list.add(li);
        ManagerEmployee managerEmployee = new ManagerEmployee();
        managerEmployee.setSex(1);
        managerEmployee.setName("w王");
        managerEmployee.setSalary(10000);
        managerEmployee.setPerformance("拍马屁");
        list.add(managerEmployee);
        for(Employee employee:list){
            employee.accept(new VisitorImpl());
        }
    }
}
