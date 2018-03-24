package pattern_design.decorate;

/**
 * Created by yangyuan on 2018/3/22.
 */
public class HighScoreDerocate extends Decorate{
    public HighScoreDerocate(SchoolReport schoolReport){
        super(schoolReport);
    }
    private  void highScore(){
        System.out.println("最高分为 78 ，80 ");
    }

    @Override
    public void report(){
        highScore();
        super.report();
    }
}
