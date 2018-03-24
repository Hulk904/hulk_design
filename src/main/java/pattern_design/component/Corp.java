package pattern_design.component;


/**
 * Created by yangyuan on 2018/3/24.
 */
public abstract class Corp {
    private String name = "";

    private String position = "";

    private int salary = 0;

    public Corp(String name,String position,int salary){
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
    public String getInfo(){
        return  "姓名 ：" + name + "，职位： " + position + ", 薪水：" + salary;

    }
}
