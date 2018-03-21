package pattern_design.responsibility_chain;

/**
 * Created by yangyuan on 2018/3/20.
 */
public abstract class Handler {

    public final static int FATHER_LEVEL = 1;
    public final static int HUABAND_LEVEL =2;
    public final static int SON_LEVEL = 3;

    private int handlerLevel;

    private Handler next;



    public Handler(int handlerLevel){
        this.handlerLevel = handlerLevel;
        }

    public void setNest(Handler handler){
        this.next = next;
    }

    public void handleRequest(Women women){
        if(women.getTyp() == handlerLevel){
            response(women);
        }else {
            if(next != null){
                next.handleRequest(women);
            }else{
                System.out.println("没有人处理了。");
            }
        }
    }

    abstract void response(Women women);

}
