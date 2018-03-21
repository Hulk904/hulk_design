package pattern_design.responsibility_chain;

/**
 * Created by yangyuan on 2018/3/20.
 */
public class FatherHandler extends Handler {

    public FatherHandler(){
        super(Handler.FATHER_LEVEL);
    }


    @Override
    void response(Women women) {
        System.out.println( women.getRequst());
        System.out.println("父亲同意");

    }
}
