package cn.bushadie.designPatterns.StructurePatterns.BridgePattern;

/**
 * @author jdmy
 * on 2018/11/19.
 **/
public abstract  class Shape {
    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }
    public abstract void draw();
}
