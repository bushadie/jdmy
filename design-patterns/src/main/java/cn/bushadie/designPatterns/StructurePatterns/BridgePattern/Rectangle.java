package cn.bushadie.designPatterns.StructurePatterns.BridgePattern;

/**
 * @author jdmy
 * on 2018/11/19.
 **/
public class Rectangle extends Shape {
    private int x;
    private int y;

    public Rectangle(int x, int y, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
    }
    public void draw() {
        drawAPI.draw(0, x, y);
    }
}
