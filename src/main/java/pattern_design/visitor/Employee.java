package pattern_design.visitor;

/**
 * Created by yangyuan on 2018/3/27.
 */
public abstract class Employee {
    public final int MAN = 1;
    public final int WOMEN = 2;

    private String name;

    private int salary;

    private int sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public abstract void  accept(Visitor visitor);
}
