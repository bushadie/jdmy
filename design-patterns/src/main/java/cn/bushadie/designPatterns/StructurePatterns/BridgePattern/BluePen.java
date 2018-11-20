package cn.bushadie.designPatterns.StructurePatterns.BridgePattern;

/**
 * @author jdmy
 * on 2018/11/19.
 **/
public class BluePen implements DrawAPI {
    @Override
    public void draw(int radius,int x,int y) {
        System.out.println("用蓝色笔画图，radius:"+radius+", x:"+x+", y:"+y);
    }
}
