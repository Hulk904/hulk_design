package pattern_design.responsibility_chain;

/**
 * Created by yangyuan on 2018/3/20.
 */
public class HusbandHandler extends Handler{

    public HusbandHandler(){
        super(Handler.HUABAND_LEVEL);
    }

    @Override
    void response(Women women) {
        System.out.println( women.getRequst());
        System.out.println("老公同意。");
    }
}
