package pattern_design.decorate;

/**
 * Created by yangyuan on 2018/3/22.
 */
public class SortDecorate extends Decorate{

    public SortDecorate(SchoolReport schoolReport){
        super(schoolReport);
    }

    private void reportSort(){
        System.out.println("我是排名第38");
    }

    @Override
    public void report(){
        super.report();
        reportSort();
    }

}
