import java.util.concurrent.TimeUnit;

/**
 * Created by yangyuan on 2020/3/10.
 */
public class DeadLock {
    static class Friend{
        private final String name;
        public Friend(String name){
            this.name = name;
        }
        public String getName(){
            return this.name;
        }
        public void bow(Friend bower){
            synchronized (this){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(this.name + " === " + bower.getName());
                bower.bowBack(this);
            }
        }
        public void bowBack(Friend bower){
            synchronized (this){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(this.name + "===" + bower.getName());
            }
        }
    }

    public static void main(String[] args) {
        final Friend alp = new Friend("al");
        final Friend gas = new Friend("ga");
        new Thread(() -> alp.bow(gas)).start();
        new Thread(() -> gas.bow(alp)).start();
    }
}
