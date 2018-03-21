package pattern_design.responsibility_chain;

/**
 * Created by yangyuan on 2018/3/20.
 */
public class SonHandler extends Handler {

    public SonHandler(){
        super(Handler.SON_LEVEL);
    }

    void response(Women women) {
        System.out.println( women.getRequst());
        System.out.println("儿子同意");
    }
}
