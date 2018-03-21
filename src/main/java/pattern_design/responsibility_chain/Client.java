package pattern_design.responsibility_chain;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by yangyuan on 2018/3/20.
 */
public class Client {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Women> list = new ArrayList<Women>();
        for(int i = 0 ;i < 4 ;i ++){
            list.add(new WomenImpl(random.nextInt(3),"要去逛街"));
        }
        Handler handler = new FatherHandler();
        Handler handler1 = new HusbandHandler();
        Handler handler2 = new SonHandler();
        handler.setNest(handler1);
        handler1.setNest(handler2);
        for (Women women:list){
            handler.handleRequest(women);
        }
    }
}
