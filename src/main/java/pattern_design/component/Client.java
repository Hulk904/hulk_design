package pattern_design.component;

import java.util.List;

/**
 * Created by yangyuan on 2018/3/24.
 * 缺点破坏了依赖倒置原则  很多地方只能用到Branch子类而不是面向接口
 * demo 属于安全组合模式
 * 还有一种是透明的组合模式：
 * 就是把所有的方法都放在抽象类中，对于子类没有的方法给个默认实现抛异常并加上deprecate注解
 * 透明组合模式的好处就是没有破坏依赖倒置原则，不需要使用具体的子类而导致的强制类型转换
 */
public class Client {
    public static void main(String[] args) {
        Branch root = compositeCorp();
        System.out.println(root.getInfo());
        System.out.println(getTreeInfo(root));
    }

    public static String getTreeInfo(Branch root){
        List<Corp> list = root.getSubs();
        String info = "";
        for(Corp s : list){
            if(s instanceof Leaf){
                info += (s.getInfo() + "\n");
            }else {
                info += (s.getInfo() + "\n" + getTreeInfo((Branch) s));
            }
        }
        return info;
    }
    static Branch compositeCorp(){
        Branch root = new Branch("老大","ceo",100000);
        Branch jl1 = new Branch("王经理","po",20000);
        root.addSub(jl1);
        Leaf leaf1 = new Leaf("fef","efefe",1000);
        jl1.addSub(leaf1);
        Leaf leaf2 = new Leaf("ddd","fffff",2000);
        jl1.addSub(leaf2);
        Branch jl2 = new Branch("杨经理","po",20000);
        root.addSub(jl2);
        Leaf leaf3 = new Leaf("cccc","wwww",3000);
        jl2.addSub(leaf3);
        return root;
    }
}
