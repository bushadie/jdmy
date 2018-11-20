package cn.bushadie.designPatterns.StructurePatterns.FacadePattern;

/**
 * @author jdmy
 * on 2018/11/20.
 **/
public class APP {
    public void usually(){
        // 画一个圆形
        Shape circle = new Circle();
        circle.draw();

        // 画一个长方形
        Shape rectangle = new Rectangle();
        rectangle.draw();
    }

    public  void faced() {
        ShapeMaker shapeMaker = new ShapeMaker();

        // 客户端调用现在更加清晰了
        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
