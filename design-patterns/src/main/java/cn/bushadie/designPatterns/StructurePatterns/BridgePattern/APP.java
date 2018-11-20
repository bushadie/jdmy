package cn.bushadie.designPatterns.StructurePatterns.BridgePattern;

/**
 * @author jdmy
 * on 2018/11/19.
 **/
public class APP {
    public static void main(String[] args) {
        Shape greenCircle = new Circle(10, new GreenPen());
        Shape redRectangle = new Rectangle(4, 8, new RedPen());

        greenCircle.draw();
        redRectangle.draw();
    }
}
