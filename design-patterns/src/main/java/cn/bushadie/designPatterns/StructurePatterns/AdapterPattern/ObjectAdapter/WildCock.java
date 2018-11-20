package cn.bushadie.designPatterns.StructurePatterns.AdapterPattern.ObjectAdapter;

/**
 * @author jdmy
 * on 2018/11/19.
 **/
public class WildCock implements Cock {
    public void gobble() {
        System.out.println("咕咕叫");
    }
    public void fly() {
        System.out.println("鸡也会飞哦");
    }
}
