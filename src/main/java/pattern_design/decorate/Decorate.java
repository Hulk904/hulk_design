package pattern_design.decorate;

/**
 * Created by yangyuan on 2018/3/22.
 */
public abstract class Decorate extends  SchoolReport{

    private SchoolReport schoolReport;

    public Decorate(SchoolReport schoolReport){
        this.schoolReport = schoolReport;
    }

    public void report(){
        schoolReport.report();
    }

    public void sign(String name){
        schoolReport.sign(name);
    }
}
