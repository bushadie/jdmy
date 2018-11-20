package cn.bushadie.designPatterns.StructurePatterns.AdapterPattern.ObjectAdapter;

/**
 * @author jdmy
 * on 2018/11/19.
 **/
public class APP {
    public void adapter(){
        // 有一只野鸡
        Cock wildCock = new WildCock();
        // 成功将野鸡适配成鸭
        Duck duck = new CockAdapter(wildCock);
    }
}
