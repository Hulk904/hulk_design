package pattern_design.responsibility_chain;

/**
 * Created by yangyuan on 2018/3/20.
 */
public class WomenImpl implements  Women{

    private int type;

    private String request;

    public WomenImpl(int type,String request){
        this.type = type;
        switch (this.type){
            case 1:
                this.request = "女儿请求是：" + request;break;
            case 2:
                this.request = "妻子请求是：" + request;break;
            case 3:
                this.request = "母亲请求是：" + request;break;
        }
    }

    public int getTyp() {
        return type;
    }

    public String getRequst() {
        return request;
    }
}
