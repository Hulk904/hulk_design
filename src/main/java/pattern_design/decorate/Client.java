package pattern_design.decorate;

/**
 * Created by yangyuan on 2018/3/22.
 */
public class Client {
    public static void main(String[] args) {
        SchoolReport schoolReport =  new FourGradeSchoolReport();
        schoolReport = new HighScoreDerocate(schoolReport);
        schoolReport = new SortDecorate(schoolReport);
        schoolReport.report();
        schoolReport.sign("yangyuan");
    }
}
