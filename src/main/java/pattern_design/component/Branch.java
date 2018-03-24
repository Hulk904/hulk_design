package pattern_design.component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2018/3/24.
 */
public class Branch extends Corp {

    List<Corp> subList = new ArrayList<Corp>();

    public Branch(String name, String position, int salary) {
        super(name, position, salary);
    }

    public void addSub(Corp corp){
        subList.add(corp);
    }

    public List<Corp> getSubs(){
        return subList;
    }
}
