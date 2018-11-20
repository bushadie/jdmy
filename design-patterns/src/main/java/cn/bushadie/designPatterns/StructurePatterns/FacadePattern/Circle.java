package cn.bushadie.designPatterns.StructurePatterns.FacadePattern;

/**
 * @author jdmy
 * on 2018/11/20.
 **/
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Circle::draw()");
    }
}
