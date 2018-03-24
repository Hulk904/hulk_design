package pattern_design.decorate;

/**
 * Created by yangyuan on 2018/3/22.
 */
public class FourGradeSchoolReport extends SchoolReport{
    @Override
    public void report() {
        System.out.println("尊敬的家长：");
        System.out.println(".....");
        System.out.println("语文 62 数学 65  体育98 自然 63");
        System.out.println(".....");
        System.out.println("     家长签名：");
    }

    @Override
    public void sign(String name ) {
        System.out.println("家长签名为" + name);
    }
}
